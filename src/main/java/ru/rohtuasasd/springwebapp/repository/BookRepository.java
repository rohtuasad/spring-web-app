package ru.rohtuasasd.springwebapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rohtuasasd.springwebapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
