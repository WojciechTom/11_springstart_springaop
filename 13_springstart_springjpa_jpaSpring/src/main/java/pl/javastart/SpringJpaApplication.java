package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.javastart.dao.BookDao;
import pl.javastart.model.Book;


@Configuration
@ComponentScan
public class SpringJpaApplication {

	
public static void main(String[] args){
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaApplication.class);
	BookDao bdi = ctx.getBean(BookDao.class);
	
	Book book = new Book("4321", "Ken Follet", "œwiat bez konca");
	bdi.save(book);
	
	System.out.println("ksia¿ka dodana " + bdi.get(1L).toString());
	ctx.close();
	}
}
