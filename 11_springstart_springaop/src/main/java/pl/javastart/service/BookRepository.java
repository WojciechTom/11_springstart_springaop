package pl.javastart.service;

import java.util.*;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import pl.javastart.model.Book;


@Component
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class BookRepository implements GenericRepository <String, Book> {

	
	private List<Book> books;
	
	
	
	public BookRepository() {
		books = new LinkedList<>();
	}

	
	
	
	@Override
	public Book get(String isbn) {
		if(isbn==null || (isbn.length() != 10))
			throw new IllegalArgumentException("You have to provide valid ISBN number");
		
		Book find = books.stream().filter(b->isbn.equals(b.getIsbn())).findFirst().get();
		randomPause(300);
		return find;
	}

	
	
	@Override
	public void add(Book book) {
		if(book == null || book.getIsbn() == null || book.getTitle() == null || book.getAuthor() == null)
			throw new IllegalArgumentException("Book cannot have null fields");
		books.add(book);
		randomPause(250);
	}


	
	
	
	private void randomPause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
