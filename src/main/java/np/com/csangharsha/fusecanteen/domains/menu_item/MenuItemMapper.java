package np.com.csangharsha.fusecanteen.domains.menu_item;


import np.com.csangharsha.fusecanteen.base.BaseMapper;
import np.com.csangharsha.fusecanteen.domains.menu_category.MenuCategoryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {
        MenuCategoryMapper.class
})
public interface MenuItemMapper extends BaseMapper<MenuItemDto, MenuItem> {

    @Override
    @Mappings({
            @Mapping(source = "menuCategoryId", target = "menuCategory.id"),
            @Mapping(source = "menuCategoryName", target = "menuCategory.name")
    })
    MenuItem toEntity(MenuItemDto dto);

    @Override
    @Mappings({
            @Mapping(source = "menuCategory.id", target = "menuCategoryId"),
            @Mapping(source = "menuCategory.name", target = "menuCategoryName")
    })
    MenuItemDto toDto(MenuItem entity);

}
