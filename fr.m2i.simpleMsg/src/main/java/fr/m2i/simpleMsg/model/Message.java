/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.model;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 *
 * @author RAISA
 */
@Entity
@Table(name="messages")
public class Message {
     @Id
    @Column(name="id_message", nullable=false )
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long id;
    
     @Column(name="sender", length=100, nullable=false )
    private String sender;
    
      @Column(name="content", columnDefinition="TEXT    ", nullable=false )
    private String content;
     
    @Column(name="date", length=200, nullable=false )
    private Date date;
    
    @JoinColumn(name="id_chanel", nullable=false )
    @ManyToOne
    private Chanel chanel;

    public Message() {
    }

    public Message(Long id, String sender, String content, Date date) {
        this.id = id;
        this.sender = sender;
        this.content = content;
        this.date = date;
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

    public Chanel getChanel() {
        return chanel;
    }

    public void setChanel(Chanel chanel) {
        this.chanel = chanel;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", sender=" + sender + ", content=" + content + ", date=" + date + '}';
    }
    
}
