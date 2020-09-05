package np.com.csangharsha.fusecanteen.domains.today_menu;

import java.util.List;

public interface TodayMenuService {

    TodayMenu save(TodayMenu todayMenu);
    List<TodayMenu> getTodayMenu();
    void delete(TodayMenu todayMenu);

}
