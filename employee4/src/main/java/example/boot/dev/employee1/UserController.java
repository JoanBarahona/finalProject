package example.boot.dev.employee1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
//
	@RequestMapping("/allUsers")
	public String getAllUsers(Model boxToView) {

		boxToView.addAttribute("userListfromControllerAndDB", userRepository.findAll());

		return "users";
	}

	@RequestMapping("/deleteUser")
	public String removeUser(int id, Model model) {

		// System.out.println("inside removeEmployee" + id);
		Optional<User> userFound = findOneUserById(id);

		// System.out.println("find inside removeUser" + userFound.get());

		if (userFound.isPresent()) {

			userRepository.deleteById(id);
			model.addAttribute("message", "deleted user confirmation");
			model.addAttribute("userDeleted", userFound.get());
		}

		else {
			model.addAttribute("message", "deleted employee error, maybe there is no id .... or network connection .. or is already deleted few miliseconds ago .. or ...");
		}

		// System.out.println("finishing removeUser" + id);
		return "deleteduser.html";
	}

	@RequestMapping("/newUSer")
	public String newUser() {

		return "newuser.html";
	}

	@RequestMapping("/addUser")
	public String inserEmployee(User user) {

		userRepository.save(user);

		return "redirect:/user/allUsers";
	}

	@RequestMapping("/updateUser")
	public String updateUser(int id, Model model) {

		Optional<User> userFound = findOneUserById(id);

		if (userFound.isPresent()) {

			model.addAttribute("userfromController", userFound.get());
			return "updateuser";
		}

		else
			return "notfound.html";
	}

	@PostMapping("/replaceUser/{idFromView}")
	public String replaceUser(@PathVariable("idFromView") int id, User user) {

		Optional<User> userFound = findOneUserById(id);

		if (userFound.isPresent()) {

			if (user.getName() != null)
				userFound.get().setName(user.getName());
			if (user.getSurname() != null)
				userFound.get().setSurname(user.getSurname());
			if (user.getPassword() != null)
				userFound.get().setPassword(user.getPassword());
			if (user.getEmail() != null)
				userFound.get().setEmail(user.getEmail());
			if (user.getAge() != 0)
				userFound.get().setAge(user.getAge());
			if (user.getMonthSalary() != 0.0)
				userFound.get().setMonthSalary(user.getMonthSalary());

			userRepository.save(userFound.get());
			return "redirect:/user/allUser";

		} else
			return "notfound.html";

	}
	
	@RequestMapping("/detailUser")
	public String detailUser(int id, Model model) {

		Optional<User> userFound = findOneUserById(id);

		if (userFound.isPresent()) {

			model.addAttribute("userfromController", userFound.get());
			return "detailemployee";
		}

		else
			return "notfound.html";
	}
	
	@RequestMapping("/deleteAllUsers")
	public String deleteAllUsers () {

		
		userRepository.deleteAll();
		

		return "redirect:/user/allUsers";

	}

//--------------------------------------------------------------------------------
//------------------------- service to controller --------------------------------
//--------------------------------------------------------------------------------

	public Optional<User> findOneUserById(int id) {

		// System.out.println("inside findUser" + id);
		Optional<User> userFound = userRepository.findById(id);
		// System.out.println("finishing findUser" + id);
		// System.out.println("finishing findUser" + userFound.get());
		return userFound;
	}

}
