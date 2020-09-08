package np.com.csangharsha.fusecanteen.domains.order_item;

import np.com.csangharsha.fusecanteen.base.BaseMapper;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItem;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItemDto;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItemMapper;
import np.com.csangharsha.fusecanteen.domains.order.OrderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {
        OrderMapper.class,
        MenuItemMapper.class
})
public interface OrderItemMapper extends BaseMapper<OrderItemDto, OrderItem> {

    @Override
    @Mappings({
            @Mapping(source = "orderId", target = "order.id")
    })
    OrderItem toEntity(OrderItemDto dto);

    @Override
    @Mappings({
            @Mapping(source = "order.id", target = "orderId")
    })
    OrderItemDto toDto(OrderItem entity);

}
