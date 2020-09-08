package np.com.csangharsha.fusecanteen.domains.order;

import np.com.csangharsha.fusecanteen.base.BaseMapper;
import np.com.csangharsha.fusecanteen.domains.order_item.OrderItemMapper;
import np.com.csangharsha.fusecanteen.domains.user.UserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        UserMapper.class,
        OrderItemMapper.class
})
public interface OrderMapper extends BaseMapper<OrderDto, Order> {
}
