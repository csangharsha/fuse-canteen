package np.com.csangharsha.fusecanteen.domains.user;

import np.com.csangharsha.fusecanteen.base.BaseResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(BaseResource.BASE_URL + UserResource.BASE_URL)
public class UserResource extends BaseResource<User, UserDto> {

    public static final String BASE_URL = "/users";

    public UserResource(UserService service, UserMapper mapper) {
        super(service, mapper);
    }
}
