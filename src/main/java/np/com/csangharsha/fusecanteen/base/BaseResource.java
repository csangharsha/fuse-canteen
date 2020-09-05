package np.com.csangharsha.fusecanteen.base;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseResource<T extends BaseEntity, D extends BaseDto> {

    public static final String BASE_URL = "/api";

    private final BaseService<T> service;
    private final BaseMapper<D, T> mapper;

    @GetMapping
    public ResponseEntity<Iterable<D>> getAll() {
        Iterable<T> results = service.findAll();
        List<D> dtos = mapper.toDto(results);
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> get(@PathVariable Long id) {
        Optional<T> result = service.findOne(id);
        return result.map(r -> ResponseEntity.ok().body(mapper.toDto(r))).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) throws URISyntaxException {
        if (dto.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        T entity = mapper.toEntity(dto);
        entity = service.save(entity);
        D newDto = mapper.toDto(entity);
        return ResponseEntity.created(new URI(BASE_URL + "/" + newDto.getId())).body(newDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@RequestBody D dto, @PathVariable Long id) {
        if (dto.getId() == null || !dto.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        T entity = mapper.toEntity(dto);
        entity = service.update(entity);
        D newDto = mapper.toDto(entity);
        return ResponseEntity.ok().body(newDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
