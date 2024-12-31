package in.kkpit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kkpit.entity.BookList;
import in.kkpit.repo.BookListRepository;

@Service
public class MyBookService {
	@Autowired
	private BookListRepository myBook;
	
	public void saveMyBook(BookList book) {
		myBook.save(book);
	}
	public List<BookList> getAllMyBooks(){
		return myBook.findAll();
	}
}
