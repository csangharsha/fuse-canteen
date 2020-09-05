package np.com.csangharsha.fusecanteen.domains.today_menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItemDto;

import java.time.LocalDate;

@Data
public class TodayMenuDto {
    private MenuItemDto menuItem;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate todayDate;
}
