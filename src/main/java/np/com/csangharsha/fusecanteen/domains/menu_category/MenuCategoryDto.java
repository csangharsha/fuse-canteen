package np.com.csangharsha.fusecanteen.domains.menu_category;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import np.com.csangharsha.fusecanteen.base.BaseDto;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class MenuCategoryDto extends BaseDto {

    private String name;

    @CreationTimestamp
    @JsonFormat(pattern = "MMMM dd,yyyy HH:mm:ss")
    private LocalDateTime addedDate;

    @UpdateTimestamp
    @JsonFormat(pattern = "MMMM dd,yyyy HH:mm:ss")
    private LocalDateTime updateDate;

}
