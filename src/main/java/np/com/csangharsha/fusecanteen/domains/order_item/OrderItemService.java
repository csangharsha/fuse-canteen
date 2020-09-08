package np.com.csangharsha.fusecanteen.domains.order_item;

import np.com.csangharsha.fusecanteen.base.BaseService;

import java.util.Set;

public interface OrderItemService extends BaseService<OrderItem> {

    Set<OrderItem> saveAll(Set<OrderItem> orderItems);

}
