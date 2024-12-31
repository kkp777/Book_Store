package in.kkpit.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.kkpit.entity.Book;
import in.kkpit.entity.BookList;
import in.kkpit.service.BookService;
import in.kkpit.service.MyBookService;

@Controller
public class BookController {
	
	//private BookRepository 
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookService myBookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return"bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBook();
		
		
//		
//		ModelAndView m=new ModelAndView();
//		m.addObject("book","list");
//		m.setViewName("bookList");
		return new ModelAndView("bookList","book",list);
		
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBook(Model model) {
		List<BookList>list=myBookService.getAllMyBooks();
		
		model.addAttribute("book",list);
		//model.addAttribute("Msg", Msg);
		return "myBook";
		
	}
	
	@GetMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		BookList mb=new BookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBook(mb);
		String Msg="Added Successfully";
		model.addAttribute("msg",Msg);
		return "redirect:/my_books";
		//return new ModelAndView("my_books","msg",Msg);
	}
	
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
		
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}

}
