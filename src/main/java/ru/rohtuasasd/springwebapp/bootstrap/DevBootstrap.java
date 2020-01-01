package ru.rohtuasasd.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.rohtuasasd.springwebapp.model.Author;
import ru.rohtuasasd.springwebapp.model.Book;
import ru.rohtuasasd.springwebapp.model.Publisher;
import ru.rohtuasasd.springwebapp.repository.AuthorRepository;
import ru.rohtuasasd.springwebapp.repository.BookRepository;
import ru.rohtuasasd.springwebapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher harper = new Publisher("Harper Collins", "New York");
        publisherRepository.save(harper);

        Publisher worx = new Publisher("Worx", "London");
        publisherRepository.save(worx);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(worx);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
