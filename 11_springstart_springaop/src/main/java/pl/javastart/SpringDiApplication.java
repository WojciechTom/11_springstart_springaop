package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import pl.javastart.model.Book;
import pl.javastart.service.BookRepository;
import pl.javastart.service.GenericRepository;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class SpringDiApplication {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class); 
	
	
		
		
		//GenericRepository<String, Book> repo = ctx.getBean(GenericRepository.class);
		
		BookRepository bookRepo = ctx.getBean(BookRepository.class);
		
		bookRepo.add(new Book("1111111111", "Pierwsza", "pierwszy autor"));
		bookRepo.add(new Book("2222222222", "Druga", "drugi autor"));
		bookRepo.add(new Book("3333333333", "Trzecia", "trzeci autor"));
	

		Book book = bookRepo.get("1111111111");
		
		System.out.println(book.toString());
		
		ctx.close();
	}

}
