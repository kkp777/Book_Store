package in.kkpit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MyBooks_Tbl")
public class BookList {
	@Id
	private int id;
	private String name;
	private String author;
	private String price;
	public BookList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookList(int id, String name, String author, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookList [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
	
}
