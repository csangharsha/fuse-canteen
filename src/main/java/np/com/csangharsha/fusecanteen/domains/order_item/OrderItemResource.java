package np.com.csangharsha.fusecanteen.domains.order_item;

import np.com.csangharsha.fusecanteen.base.BaseResource;
import np.com.csangharsha.fusecanteen.domains.order_item.projections.PopularPendingOrderItem;
import np.com.csangharsha.fusecanteen.domains.order_item.projections.PopularPendingOrderItemDto;
import np.com.csangharsha.fusecanteen.domains.order_item.projections.PopularPendingOrderItemMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BaseResource.BASE_URL + OrderItemResource.BASE_URL)
public class OrderItemResource extends BaseResource<OrderItem, OrderItemDto> {
    public static final String BASE_URL = "/order-item";

    private final PopularPendingOrderItemMapper popularPendingOrderItemMapper;
    private final OrderItemService orderItemService;

    public OrderItemResource(OrderItemService service, OrderItemMapper mapper, PopularPendingOrderItemMapper popularPendingOrderItemMapper) {
        super(service, mapper);
        this.orderItemService = service;
        this.popularPendingOrderItemMapper = popularPendingOrderItemMapper;
    }

    @GetMapping("/popular")
    public ResponseEntity<List<PopularPendingOrderItemDto>> getPopularPendingOrderItem() {
        List<PopularPendingOrderItem> popularPendingOrderItems = orderItemService.getPopularPendingOrderItem();
        return ResponseEntity.ok().body(popularPendingOrderItemMapper.toDto(popularPendingOrderItems));
    }
}
