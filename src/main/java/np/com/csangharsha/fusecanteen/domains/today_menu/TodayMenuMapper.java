package np.com.csangharsha.fusecanteen.domains.today_menu;

import np.com.csangharsha.fusecanteen.base.BaseMapper;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItemMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {
        MenuItemMapper.class
})
public interface TodayMenuMapper extends BaseMapper<TodayMenuDto, TodayMenu> {

    @Override
    @Mappings({
            @Mapping(source = "todayDate", target = "todayMenuId.todayDate")
    })
    TodayMenu toEntity(TodayMenuDto dto);

    @Override
    @Mappings({
            @Mapping(source = "todayMenuId.todayDate", target = "todayDate")
    })
    TodayMenuDto toDto(TodayMenu entity);

}
