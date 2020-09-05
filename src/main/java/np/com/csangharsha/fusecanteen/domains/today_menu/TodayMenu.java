package np.com.csangharsha.fusecanteen.domains.today_menu;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItem;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "today_menu")
@Setter
@Getter
@NoArgsConstructor
public class TodayMenu {

    @EmbeddedId
    private TodayMenuId todayMenuId;

    @MapsId("menuItemId")
    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

}
