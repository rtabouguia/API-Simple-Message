/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.dto;

import fr.m2i.simpleMsg.model.Message;
import java.util.List;

/**
 *
 * @author RAISA
 */
public class ChanelDTO {

    private Long id;
     private String name;
    private String description;
    private List <Message> messages;
    
    
    public ChanelDTO() {
    }

    public ChanelDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List <Message> getMessages() {
        return messages;
    }

    public void setMessages(List <Message> messages) {
        this.messages = messages;
    }

}
