package np.com.csangharsha.fusecanteen.domains.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User t) {
        return repository.save(t);
    }

    @Override
    public User update(User t) {
        return repository.save(t);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findOne(Long id) {
        return repository.findById(id);
    }
}
