package np.com.csangharsha.fusecanteen.bootstrap;

import lombok.RequiredArgsConstructor;
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
    }
}
