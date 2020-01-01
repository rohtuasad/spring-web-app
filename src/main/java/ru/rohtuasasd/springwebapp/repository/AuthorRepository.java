package ru.rohtuasasd.springwebapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rohtuasasd.springwebapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
