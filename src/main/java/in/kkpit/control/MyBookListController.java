package in.kkpit.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.kkpit.repo.BookListRepository;

@Controller
public class MyBookListController {
	
	@Autowired
	private BookListRepository service1;
	@GetMapping("/deleteMyList/{id}")
	public String getMyList(@PathVariable("id") int id) {
		service1.deleteById(id);
		return "redirect:/my_books";
	}

}
