/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.dto;

import fr.m2i.simpleMsg.model.Chanel;
import fr.m2i.simpleMsg.model.Message;

/**
 *
 * @author RAISA
 */
public class MessageMapper {
    
    public static MessageDTO buildMessageDTO(Message message){
        
        if (message == null){
            return new MessageDTO();
        }
        //Long id, String sender, String content, Date date, Chanel chanel
        
        ChanelDTO chanelDTO = null;
        
      if (message.getChanel() != null){
          chanelDTO = ChanelMapper.buildChanelDTO(message.getChanel());
      }
        
        return new MessageDTO(
                message.getId(),
                message.getSender(),
                message.getContent(),
                chanelDTO        
        );    
    }
    
    public static Message buildMessage(MessageDTO dto){
        
        if (dto == null){
            return null;
        }
        
        Chanel chanel = null;
        
        if(dto.getChanelDTO() != null && dto.getChanelDTO().getId() !=null){
            chanel = new Chanel();
            chanel.setId(dto.getChanelDTO().getId());
        }
        
       return new Message (
        dto.getId(),
        dto.getSender(),
       dto.getContent(),
       chanel
               );
    }
    
    public static Message copy(Message message, Message content){
        
        if(message == null || content == null){
            return null;
        }
       if(content.getContent() !=null){
           message.setContent(content.getContent());
       }
   return message;
      }
    
    
}
