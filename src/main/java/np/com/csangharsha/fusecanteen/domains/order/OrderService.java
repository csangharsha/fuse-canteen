package np.com.csangharsha.fusecanteen.domains.order;

import np.com.csangharsha.fusecanteen.base.BaseService;

import java.util.List;

public interface OrderService extends BaseService<Order> {

    List<Order> getOrderHistory(Long userId);

    List<Order> getPendingOrder(Long userId);
}
