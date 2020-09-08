package np.com.csangharsha.fusecanteen.domains.order_item;

import np.com.csangharsha.fusecanteen.base.BaseResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseResource.BASE_URL + OrderItemResource.BASE_URL)
public class OrderItemResource extends BaseResource<OrderItem, OrderItemDto> {
    public static final String BASE_URL = "/order-item";

    public OrderItemResource(OrderItemService service, OrderItemMapper mapper) {
        super(service, mapper);
    }
}
