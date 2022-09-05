/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.service;

import fr.m2i.simpleMsg.model.Message;
import java.util.List;

/**
 *
 * @author RAISA
 */
public interface IMessageService {
    
    
    public List <Message> findAllMessagesByChanel();
    
    public Message findMessageById();
    
    public Message createMessage();
    
    public Message updateMessage();
    
    public void deleteMessage();
    
    
}
