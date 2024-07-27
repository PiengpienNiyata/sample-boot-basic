package th.mfu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
    List<Customer> findAll();

    boolean existsById(Long id);
}
