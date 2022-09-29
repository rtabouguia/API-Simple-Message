/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.service;

import fr.m2i.simpleMsg.model.Message;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author RAISA
 */
public interface IMessageService {
    
    //Récupère tous les messages d'un canal
   @Query(value="select u from Message u where  u.chanel= :id") 
    List <Message> findAllMessagesByChanel(Long id);
    
    //Récupère un message selon son Id
    Message findMessageById(Long id);
    
    //Cree un nouveau message
    Message createMessage(Message message);
    
    //met à jour un message
    Message updateMessage(Long id, Message content);
    
    //Supprime un message
    void deleteMessage(Long id);
    
    
}
