package guru.springframework.spring5webapp.repositorys;


import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher,Long> {
}
