package np.com.csangharsha.fusecanteen.domains.order_item.projections;

import np.com.csangharsha.fusecanteen.base.BaseMapper;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItemMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        MenuItemMapper.class
})
public interface PopularPendingOrderItemMapper extends BaseMapper<PopularPendingOrderItemDto, PopularPendingOrderItem> {
}
