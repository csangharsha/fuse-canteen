package np.com.csangharsha.fusecanteen.base;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    private final BaseRepository<T> baseRepository;

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public T update(T t) {
        return baseRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Optional<T> findOne(Long id) {
        return baseRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        baseRepository.deleteById(id);
    }

}
