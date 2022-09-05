/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.dto;

import fr.m2i.simpleMsg.model.Chanel;
import java.util.Date;

/**
 *
 * @author RAISA
 */
public class MessageDTO {

    private Long id;
    private String sender;
    private String content;
    private Date date;
    private ChanelDTO chanelDTO;
   
    
    public MessageDTO() {
    }

    public MessageDTO(Long id, String sender, String content, Date date, ChanelDTO chanelDTO) {
        this.id = id;
        this.sender = sender;
        this.content = content;
        this.date = date;
        this.chanelDTO = chanelDTO;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ChanelDTO getChanelDTO() {
        return chanelDTO;
    }

    public void setChanelDTO(ChanelDTO chanelDTO) {
        this.chanelDTO = chanelDTO;
    }

    

    
}