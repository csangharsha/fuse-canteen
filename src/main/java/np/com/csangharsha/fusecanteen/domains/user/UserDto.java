package np.com.csangharsha.fusecanteen.domains.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import np.com.csangharsha.fusecanteen.base.BaseDto;
import np.com.csangharsha.fusecanteen.domains.role.Role;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseDto {

    private String name;
    private String email;
    private Set<Role> roles = new HashSet<>();

}
