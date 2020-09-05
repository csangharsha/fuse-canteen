package np.com.csangharsha.fusecanteen.bootstrap;

import lombok.RequiredArgsConstructor;
import np.com.csangharsha.fusecanteen.domains.menu_category.MenuCategory;
import np.com.csangharsha.fusecanteen.domains.menu_category.MenuCategoryRepository;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItem;
import np.com.csangharsha.fusecanteen.domains.menu_item.MenuItemRepository;
import np.com.csangharsha.fusecanteen.domains.role.Role;
import np.com.csangharsha.fusecanteen.domains.role.RoleRepository;
import np.com.csangharsha.fusecanteen.domains.user.User;
import np.com.csangharsha.fusecanteen.domains.user.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuItemRepository menuItemRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        // save roles
        Role adminRole = new Role("ROLE_ADMIN");
        Role employeeRole = new Role("ROLE_EMPLOYEE");

        // save admin user
        User admin = new User("Canteen Admin", "admin@fusecanteen.com", "Nepal@123");
        admin.getRoles().add(adminRole);

        roleRepository.save(adminRole);
        roleRepository.save(employeeRole);
        userRepository.save(admin);

        // save menu Category
        MenuCategory momo = new MenuCategory();
        momo.setId(1L);
        momo.setName("Mo:Mo:");
        menuCategoryRepository.save(momo);

        MenuCategory chowmein = new MenuCategory();
        chowmein.setId(2L);
        chowmein.setName("Chowmein");
        menuCategoryRepository.save(chowmein);

        // save menu Item
        MenuItem vegMomo = new MenuItem();
        vegMomo.setId(1l);
        vegMomo.setName("Veg. Mo:Mo:");
        vegMomo.setPrice(80.0);
        vegMomo.setMenuCategory(momo);
        menuItemRepository.save(vegMomo);

        MenuItem chickenMomo = new MenuItem();
        chickenMomo.setId(2l);
        chickenMomo.setName("Chicken Mo:Mo:");
        chickenMomo.setPrice(120.0);
        chickenMomo.setMenuCategory(momo);
        menuItemRepository.save(chickenMomo);

        MenuItem buffMomo = new MenuItem();
        buffMomo.setId(3l);
        buffMomo.setName("Buff Mo:Mo:");
        buffMomo.setPrice(100.0);
        buffMomo.setMenuCategory(momo);
        menuItemRepository.save(buffMomo);

        MenuItem vegChowmein = new MenuItem();
        vegChowmein.setId(4l);
        vegChowmein.setName("Veg. Chowmein");
        vegChowmein.setPrice(90.0);
        vegChowmein.setMenuCategory(chowmein);
        menuItemRepository.save(vegChowmein);

        MenuItem chickenChowmein = new MenuItem();
        chickenChowmein.setId(5l);
        chickenChowmein.setName("Chicken Chowmein");
        chickenChowmein.setPrice(100.0);
        chickenChowmein.setMenuCategory(chowmein);
        menuItemRepository.save(chickenChowmein);

    }
}
