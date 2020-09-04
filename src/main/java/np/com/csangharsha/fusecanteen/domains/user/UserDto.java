package np.com.csangharsha.fusecanteen.domains.user;

import lombok.Data;
import np.com.csangharsha.fusecanteen.domains.role.Role;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Set<Role> roles = new HashSet<>();
}
