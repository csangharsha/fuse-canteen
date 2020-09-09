package np.com.csangharsha.fusecanteen.domains.menu_item;

import np.com.csangharsha.fusecanteen.base.BaseResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseResource.BASE_URL + MenuItemResource.BASE_URL)
public class MenuItemResource extends BaseResource<MenuItem, MenuItemDto> {

    public static final String BASE_URL = "/menu-item";

    private final MenuItemService menuItemService;

    private final MenuItemMapper menuItemMapper;

    public MenuItemResource(MenuItemService service, MenuItemMapper mapper) {
        super(service, mapper);
        this.menuItemService = service;
        this.menuItemMapper = mapper;
    }

}
