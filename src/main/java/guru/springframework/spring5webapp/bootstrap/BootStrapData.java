package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;

import guru.springframework.spring5webapp.domain.Book;

import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositorys.AuthorRepository;
import guru.springframework.spring5webapp.repositorys.BookRepository;

import guru.springframework.spring5webapp.repositorys.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepo publisherRepo;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepo publisherRepo) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub = new Publisher("Olle", "gata1", "Sundsvall");
        Author eric = new Author("Marcus", "Svantesson");
        Book book = new Book("Domain Driven Design", "123123");

        publisherRepo.save(pub);

        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(pub);

        book.setPublisher(pub);
        pub.getBooks().add(book);


        authorRepository.save(eric);
        bookRepository.save(book);

        publisherRepo.save(pub);

        Author rod = new Author("Ida", "Svantesson");
        Book noEJB = new Book("J2EE Development without EJB", "1231285190");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);



        noEJB.setPublisher(pub);
        pub.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepo.save(pub);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("NUmber of Publishers: " + pub.getBooks().size());

    }
}
