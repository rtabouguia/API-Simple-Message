package fr.m2i.simpleMsg.service;

import fr.m2i.simpleMsg.dto.MessageMapper;
import fr.m2i.simpleMsg.exception.NotFoundException;
import fr.m2i.simpleMsg.model.Chanel;
import fr.m2i.simpleMsg.model.Message;
import fr.m2i.simpleMsg.repository.MessageRepository;
import java.util.List;

/**
 *
 * @author RAISA
 */
public class MessageService implements IMessageService{
    
    private MessageRepository repo;
    private Chanel chanel;

    public MessageService(MessageRepository repo) {
        this.repo = repo;
    }
    
    
       @Override
       public List <Message> findAllMessagesByChanel(Long id, Chanel chanel){
           
        return null;
    }
    
       @Override
    public Message findMessageById(Long id) {
        return repo.findById(id).orElseThrow(
                () -> new NotFoundException("Message with id :" + id + "was not found"));
        
    }
    
       @Override
    public Message createMessage(Message message){
        return repo.save(message);
    }
    
       @Override
    public Message updateMessage(Long id, Message content){
        Message msgToUpdate = findMessageById(id);
        msgToUpdate = MessageMapper.copy(msgToUpdate, content);
                
        return repo.save(msgToUpdate);
    }
    
       @Override
    public void deleteMessage(Long id){
        Message msgToDelete =findMessageById(id);
        repo.delete(msgToDelete);

    }
}
