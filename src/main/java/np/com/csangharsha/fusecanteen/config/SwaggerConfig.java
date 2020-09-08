package np.com.csangharsha.fusecanteen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${app.basePackage}")
    private String basePackage;

    @Value("${app.basePath}")
    private String basePath;

    @Bean
    public Docket fuseCanteenAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.regex(basePath))
                .build()
                .globalOperationParameters(addParameter())
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Fuse Canteen REST API")
                .description("\"REST API for Fuse Canteen\"")
                .version("1.0.0")
                .license("API License")
                .licenseUrl("https://csangharsha.github.io/")
                .contact(new Contact("Sangharsha Chaulagain", "https://csangharsha.github.io/", "sangharsha.chaulagain@gmail.com"))
                .build();
    }

    private List<Parameter> addParameter() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.parameterType("header").name("Authorization").modelRef(new ModelRef("string")).required(false).build();
        List<Parameter> parameterBuilders = new ArrayList<>();
        parameterBuilders.add(parameterBuilder.build());
        return parameterBuilders;
    }

}
