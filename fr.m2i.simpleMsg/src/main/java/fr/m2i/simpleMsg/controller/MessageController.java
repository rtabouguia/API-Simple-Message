/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.controller;

import fr.m2i.simpleMsg.dto.MessageDTO;
import fr.m2i.simpleMsg.dto.MessageMapper;
import fr.m2i.simpleMsg.exception.NotFoundException;
import fr.m2i.simpleMsg.model.Message;
import fr.m2i.simpleMsg.response.ErrorResponseEntity;
import fr.m2i.simpleMsg.service.IMessageService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author RAISA
 */
@RestController
@RequestMapping("/v1/messages")
public class MessageController {
    
    private final IMessageService messageService;

    @Autowired
    public MessageController(IMessageService messageService) {
        this.messageService = messageService;
    }
    
    //Find all the messages posted on a chanel
    @GetMapping(value="chanel/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllMessagesByCanal(@PathVariable("id") String id) {
        
        try{
        Long msgId = Long.parseLong(id);
        List<Message> messages = messageService.findAllMessagesByChanel(msgId);
        
        List<MessageDTO> dtos  =  new ArrayList();
         
          for (Message message : messages) {
            MessageDTO dto = MessageMapper.buildMessageDTO(message);
            dtos.add(dto);
        }
          
      return ResponseEntity.status(HttpStatus.OK).body(dtos);
        }
          catch(NumberFormatException ne){
           return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "v1/messages/"+id, HttpStatus.BAD_REQUEST);
       }    catch (NotFoundException nfe){
           return ErrorResponseEntity.build("The Chanel was not found", 404, "/v1/messages"+id, HttpStatus.NOT_FOUND);
       } catch (Exception e){
           return ErrorResponseEntity.build("An Error occured", 500, "/v1/messages/"+ id, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    
    
    //Find a message from id
     @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getMessageById(@PathVariable("id") String id) {
        try {
            Long customerId = Long.parseLong(id);
            Message founded = messageService.findMessageById(customerId);
            MessageDTO dto = MessageMapper.buildMessageDTO(founded);

            return ResponseEntity.status(HttpStatus.OK).body(dto);

        } catch (NumberFormatException ne) {
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/messages/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Message was not found", 404, "/v1/messages/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/messages/" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     //New message to be posted
        @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createMessage(@RequestBody MessageDTO dto){
        try {
            Message toCreate = MessageMapper.buildMessage(dto);
            Message created = messageService.createMessage(toCreate);
            MessageDTO createdDTO = MessageMapper.buildMessageDTO(created);

            return ResponseEntity.status(HttpStatus.OK).body(createdDTO);

        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/messages", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //delete a message 
     @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<Object> removeMessage(@PathVariable("id") String id){
           
         try{
             Long customerId = Long.parseLong(id);
              messageService.deleteMessage(customerId);
              return new ResponseEntity<>("The Message have been successfully removed", HttpStatus.OK);
            
       }    catch(NumberFormatException ne){
           return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "v1/message/"+id, HttpStatus.BAD_REQUEST);
       }    catch (NotFoundException nfe){
           return ErrorResponseEntity.build("Message was not found", 404, "/v1/message"+id, HttpStatus.NOT_FOUND);
       } catch (Exception e){
           return ErrorResponseEntity.build("An Error occured", 500, "/v1/customer/"+ id, HttpStatus.INTERNAL_SERVER_ERROR);
       }
     }
     
     //Update message
    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> updateMessage(@PathVariable("id") String id,
            @RequestBody MessageDTO dto) {
        try {
            Long messageId = Long.parseLong(id);
            Message content = MessageMapper.buildMessage(dto);
            Message updated = messageService.updateMessage(messageId, content);
            MessageDTO updateDto = MessageMapper.buildMessageDTO(updated);

            return ResponseEntity.status(HttpStatus.OK).body(updateDto);

        } catch (NumberFormatException ne) {
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/messages/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("the message was not found", 404, "/v1/messages/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/messages/" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
}
