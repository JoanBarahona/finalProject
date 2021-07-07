package example.boot.dev.employee1;

import java.text.SimpleDateFormat;
//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestUserExpenses implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ShopRepository shopRepository;
	
	
	public void run(String... args) throws Exception {
		User King = new User("King", "carpenter", 36, "@King",120,"1223");
		User Sergi = new User("Sergi", "developer", 36, "@Sergi",203,"1521");
		User Artur = new User("Artur", "Fisherman", 36, "@Artur",90,"0135");
		
		userRepository.save(King);
		userRepository.save(Sergi);
		userRepository.save(Artur);
		
		Shop shop1 = new Shop ("Toys & us", "Barcelona","12357","mornings");
		Shop shop2 = new Shop ("Abacus", "Barcelona", "896235P", "mornings-afternoon");
		Shop shop3 = new Shop ("Toys & Us", "Barcelona", "457426L", "nights");
		Shop shop4 = new Shop ("Toys & Us", "Barcelona", "5465454M", "afternoons");
		
		shopRepository.save(shop1);
		shopRepository.save(shop2);
		shopRepository.save(shop3);
		shopRepository.save(shop4);
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		
		OrderService order1 = new OrderService (formater.parse("2021-07-01"), 3, "byHand", true);
		OrderService order2 = new OrderService (formater.parse("2021-07-01"), 3, "byHand", true);
		OrderService order3 = new OrderService (formater.parse("2021-07-01"), 3, "byHand", true);
		
		order1.setUser(King);
		order1.setShop(shop1);
		
		order2.setUser(King);
		order2.setShop(shop2);
		
		order3.setUser(King);
		order3.setShop(shop2);
		
		orderRepository.save(order1);
		orderRepository.save(order2);
		orderRepository.save(order3);
	}

}
