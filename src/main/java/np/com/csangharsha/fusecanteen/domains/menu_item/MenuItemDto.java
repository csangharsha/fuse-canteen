package np.com.csangharsha.fusecanteen.domains.menu_item;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import np.com.csangharsha.fusecanteen.base.BaseDto;
import np.com.csangharsha.fusecanteen.domains.menu_category.MenuCategory;
import np.com.csangharsha.fusecanteen.domains.menu_category.MenuCategoryDto;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class MenuItemDto extends BaseDto {

    private String name;

    private Double price;

    private Long menuCategoryId;

    private String menuCategoryName;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime addedDate;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;
}
