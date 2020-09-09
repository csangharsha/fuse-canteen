package np.com.csangharsha.fusecanteen.domains.menu_item;

import np.com.csangharsha.fusecanteen.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MenuItemServiceImpl extends BaseServiceImpl<MenuItem> implements MenuItemService {

    public MenuItemServiceImpl(MenuItemRepository repository) {
        super(repository);
    }

}
