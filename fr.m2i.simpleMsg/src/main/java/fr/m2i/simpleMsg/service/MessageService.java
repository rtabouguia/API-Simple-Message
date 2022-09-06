package fr.m2i.simpleMsg.service;

import fr.m2i.simpleMsg.dto.MessageMapper;
import fr.m2i.simpleMsg.exception.NotFoundException;
import fr.m2i.simpleMsg.model.Chanel;
import fr.m2i.simpleMsg.model.Message;
import fr.m2i.simpleMsg.repository.MessageRepository;
import java.util.List;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author RAISA
 */
@Service
public class MessageService implements IMessageService{
    
    private final MessageRepository repo;
   
    
    public MessageService(MessageRepository repo) {
        this.repo = repo;
     
    }
   
    
       @Override
      @Query("select u from Message u INNER JOIN u.chanel uc where uc.chanel = :id") 
       public List <Message> findAllMessagesByChanel(Long id){
                return repo.findAll();
             }
    
       @Override
    public Message findMessageById(Long id) {
        return repo.findById(id).orElseThrow(
                () -> new NotFoundException("Message with id :" + id + "was not found"));
        
    }
    
       @Override
       @Transactional
    public Message createMessage(Message message){
        return repo.save(message);
    }
    
       @Override
       @Transactional
    public Message updateMessage(Long id, Message content){
        Message msgToUpdate = findMessageById(id);
        msgToUpdate = MessageMapper.copy(msgToUpdate, content);
                
        return repo.save(msgToUpdate);
    }
    
       @Override
       @Transactional
    public void deleteMessage(Long id){
        Message msgToDelete =findMessageById(id);
        repo.delete(msgToDelete);

    }
}
