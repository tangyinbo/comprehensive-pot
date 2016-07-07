package t;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintMessageService {
	final private MessageService service;
	
	@Autowired
    public PrintMessageService(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessageString());
    }
}
