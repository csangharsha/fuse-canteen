package np.com.csangharsha.fusecanteen.domains.menu_category;

import np.com.csangharsha.fusecanteen.base.BaseResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseResource.BASE_URL + MenuCategoryResource.BASE_URL)
public class MenuCategoryResource extends BaseResource<MenuCategory, MenuCategoryDto> {

    public static final String BASE_URL = "/menu-category";

    public MenuCategoryResource(MenuCategoryService service, MenuCategoryMapper mapper) {
        super(service, mapper);
    }
}
