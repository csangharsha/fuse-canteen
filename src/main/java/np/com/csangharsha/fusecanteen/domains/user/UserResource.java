package np.com.csangharsha.fusecanteen.domains.user;

import np.com.csangharsha.fusecanteen.base.BaseResource;
import np.com.csangharsha.fusecanteen.domains.order.Order;
import np.com.csangharsha.fusecanteen.domains.order.OrderDto;
import np.com.csangharsha.fusecanteen.domains.order.OrderMapper;
import np.com.csangharsha.fusecanteen.domains.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(BaseResource.BASE_URL + UserResource.BASE_URL)
public class UserResource extends BaseResource<User, UserDto> {

    public static final String BASE_URL = "/users";

    public final OrderService orderService;
    public final OrderMapper orderMapper;

    public UserResource(UserService service, UserMapper mapper, OrderService orderService, OrderMapper orderMapper) {
        super(service, mapper);
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<List<OrderDto>> getPendingOrders(@PathVariable("id") Long id) {
        List<Order> orders = orderService.getPendingOrder(id);
        return ResponseEntity.ok().body(orderMapper.toDto(orders));
    }

    @GetMapping("/{id}/order-history")
    public ResponseEntity<List<OrderDto>> getOrderHistoryOf(@PathVariable("id") Long id) {
        List<Order> orders = orderService.getOrderHistory(id);
        return ResponseEntity.ok().body(orderMapper.toDto(orders));
    }
}
