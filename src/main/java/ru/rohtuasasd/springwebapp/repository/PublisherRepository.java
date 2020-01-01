package ru.rohtuasasd.springwebapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.rohtuasasd.springwebapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
