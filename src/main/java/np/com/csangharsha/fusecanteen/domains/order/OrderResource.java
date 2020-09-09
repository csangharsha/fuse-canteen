package np.com.csangharsha.fusecanteen.domains.order;

import np.com.csangharsha.fusecanteen.auth.models.UserPrincipal;
import np.com.csangharsha.fusecanteen.base.BaseResource;
import np.com.csangharsha.fusecanteen.domains.order_item.OrderItem;
import np.com.csangharsha.fusecanteen.domains.order_item.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(BaseResource.BASE_URL + OrderResource.BASE_URL)
public class OrderResource extends BaseResource<Order, OrderDto> {

    public static final String BASE_URL = "/orders";

    private final OrderItemService orderItemService;

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderResource(OrderService service, OrderMapper mapper, OrderItemService orderItemService) {
        super(service, mapper);
        this.orderService = service;
        this.orderMapper = mapper;
        this.orderItemService = orderItemService;
    }

    @Override
    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto dto) throws URISyntaxException {
        if (dto.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        Order order = orderMapper.toEntity(dto);

        Set<OrderItem> orderItems = order.getOrderItems();
        order.setOrderItems(null);

        Order savedOrder = orderService.save(order);

        orderItems.forEach(orderItem -> orderItem.setOrder(savedOrder));

        orderItems = orderItemService.saveAll(orderItems);

        savedOrder.setOrderItems(orderItems);

        OrderDto newDto = orderMapper.toDto(savedOrder);

        return ResponseEntity.created(new URI(BASE_URL + "/" + newDto.getId())).body(newDto);

    }

    @GetMapping("/history")
    public ResponseEntity<List<OrderDto>> getOrderHistory() {
        Long loggedInUserId = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<Order> orderHistory = orderService.getOrderHistory(loggedInUserId);
        return ResponseEntity.ok().body(orderMapper.toDto(orderHistory));
    }
}
