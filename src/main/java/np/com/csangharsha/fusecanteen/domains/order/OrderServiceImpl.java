package np.com.csangharsha.fusecanteen.domains.order;

import np.com.csangharsha.fusecanteen.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }
}
