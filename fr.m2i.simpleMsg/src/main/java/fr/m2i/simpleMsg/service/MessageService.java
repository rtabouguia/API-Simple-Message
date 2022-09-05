package fr.m2i.simpleMsg.service;

import fr.m2i.simpleMsg.model.Message;
import fr.m2i.simpleMsg.repository.MessageRepository;
import java.util.List;

/**
 *
 * @author RAISA
 */
public class MessageService implements IMessageService{
    
    private MessageRepository repo;

    public MessageService(MessageRepository repo) {
        this.repo = repo;
    }
    
    
       @Override
       public List <Message> findAllMessagesByChanel(){
        return null;
    }
    
       @Override
    public Message findMessageById(){
        return null;
    }
    
       @Override
    public Message createMessage(){
        return null;
    }
    
       @Override
    public Message updateMessage(){
        return null;
    }
    
       @Override
    public void deleteMessage(){

    }
}
