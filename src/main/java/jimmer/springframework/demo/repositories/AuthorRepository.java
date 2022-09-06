package jimmer.springframework.demo.repositories;

import jimmer.springframework.demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
