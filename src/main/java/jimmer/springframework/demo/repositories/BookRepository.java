package jimmer.springframework.demo.repositories;

import jimmer.springframework.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
