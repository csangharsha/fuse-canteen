package np.com.csangharsha.fusecanteen.domains.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.EqualsAndHashCode;
import np.com.csangharsha.fusecanteen.base.BaseDto;
import np.com.csangharsha.fusecanteen.domains.order_item.OrderItem;
import np.com.csangharsha.fusecanteen.domains.order_item.OrderItemDto;
import np.com.csangharsha.fusecanteen.domains.user.UserDto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDto extends BaseDto {

    private String status;

    private UserDto orderBy;
    
    private Set<OrderItemDto> orderItems = new HashSet<>();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

}
