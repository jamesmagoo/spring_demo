package jimmer.springframework.demo.bootstrap;

import jimmer.springframework.demo.domain.Author;
import jimmer.springframework.demo.domain.Book;
import jimmer.springframework.demo.domain.Publisher;
import jimmer.springframework.demo.repositories.AuthorRepository;
import jimmer.springframework.demo.repositories.BookRepository;
import jimmer.springframework.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher oxford = new Publisher( );
        oxford.setAddress("King Street");
        oxford.setName("Oxford Uni Press");
        oxford.setState("Oxfordshire");
        oxford.setZip("T93HFS");
        publisherRepository.save(oxford);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","3243254");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(oxford);
        oxford.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(oxford);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "232111");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(oxford);
        oxford.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(oxford);

        System.out.println("Bootstrapping...");
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Publisher Number of Books: " + oxford.getBooks().size());
        System.out.println("Publisher Name: " + oxford.getName());

    }
}
