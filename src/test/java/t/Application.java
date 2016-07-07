package t;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {
	@Bean
	MessageService mockMessageService(){
		return new MessageService() {
			@Override
			public String getMessageString() {
				return "hello tangyinbo";
			}
		};
	}
	
	public static void main(String[] args) {
		 ApplicationContext context = 
		          new AnnotationConfigApplicationContext(Application.class);
		 PrintMessageService printer = context.getBean(PrintMessageService.class);
		 printer.printMessage();
	}
}
