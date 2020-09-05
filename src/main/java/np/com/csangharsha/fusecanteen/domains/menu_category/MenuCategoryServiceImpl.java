package np.com.csangharsha.fusecanteen.domains.menu_category;

import np.com.csangharsha.fusecanteen.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MenuCategoryServiceImpl extends BaseServiceImpl<MenuCategory> implements MenuCategoryService {

    public MenuCategoryServiceImpl(MenuCategoryRepository baseRepository) {
        super(baseRepository);
    }

}
