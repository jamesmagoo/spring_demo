package jimmer.springframework.demo.repositories;

import jimmer.springframework.demo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
