package np.com.csangharsha.fusecanteen.domains.user;

import np.com.csangharsha.fusecanteen.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
