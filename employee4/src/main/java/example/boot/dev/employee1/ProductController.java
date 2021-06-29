package example.boot.dev.employee1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	@RequestMapping("/product")
	public class ProductController {
		
		@Autowired
		ProductRepository productRepository;

		@RequestMapping("/allProduct")
		public String getAllProduct(Model boxToView) {
			
			boxToView.addAttribute("productsfromController", productRepository.findAll() );
			
			return "products.html";
		}

}
