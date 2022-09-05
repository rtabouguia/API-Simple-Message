/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.service;

import fr.m2i.simpleMsg.model.Chanel;
import fr.m2i.simpleMsg.model.Message;
import java.util.List;

/**
 *
 * @author RAISA
 */
public interface IMessageService {
    
    
    List <Message> findAllMessagesByChanel(Long id, Chanel chanel);
    
    Message findMessageById(Long id);
    
    Message createMessage(Message message);
    
    Message updateMessage(Long id, Message content);
    
    void deleteMessage(Long id);
    
    
}
