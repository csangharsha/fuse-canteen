package np.com.csangharsha.fusecanteen.config;

import lombok.RequiredArgsConstructor;
import np.com.csangharsha.fusecanteen.auth.jwt.JwtAuthenticationEntryPoint;
import np.com.csangharsha.fusecanteen.auth.jwt.JwtRequestFilter;
import np.com.csangharsha.fusecanteen.auth.service.FuseCanteenUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final FuseCanteenUserDetailsService fcUserDetailsService;

    private final JwtAuthenticationEntryPoint authenticationEntryPoint;

    private static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs"
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(fcUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public JwtRequestFilter jwtAuthenticationFilter() {
        return new JwtRequestFilter();
    }

    @Override
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                // MENU CATEGORY AND MENU ITEM
                .antMatchers("/api/menu-category").hasRole("ADMIN")
                .antMatchers("/api/menu-item").hasRole("ADMIN")

                // USER
                .antMatchers("/api/users/{\\d+}/orders").authenticated()
                .antMatchers("/api/users").hasRole("ADMIN")

                // ORDER AND ORDER-ITEM
                .antMatchers("/api/order-item").hasRole("ADMIN")
                .antMatchers("/api/orders").authenticated()

                // TODAY'S MENU
                .antMatchers(HttpMethod.GET, "/api/today-menu").authenticated()
                .antMatchers("/api/today-menu").hasRole("ADMIN")

                .antMatchers(AUTH_WHITELIST).permitAll()

                // AUTHENTICATION
                .antMatchers("/api/auth/authenticate").permitAll()

                // OTHERS
                .antMatchers("/api/*").authenticated();

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
