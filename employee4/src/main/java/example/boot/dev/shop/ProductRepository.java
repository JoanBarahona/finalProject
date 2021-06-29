package example.boot.dev.shop;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
	
	List<Product> findByName(String name);

	Product findById(int id);

}


