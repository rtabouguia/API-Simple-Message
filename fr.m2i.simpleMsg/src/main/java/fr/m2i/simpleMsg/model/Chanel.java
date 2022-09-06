/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 *
 * @author RAISA
 */

@Entity
@Table(name="chanels")
public class Chanel {
    
    @Id
    @Column(name="id_chanel", nullable=false )
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private Long id;
    
     @Column(name="name_chanel", length=100, nullable=false )
    private String name;
    
      @Column(name="description", length=200, nullable=false )
    private String description;

    @OneToMany(targetEntity=Message.class, mappedBy="chanel", cascade = CascadeType.REMOVE)
    private List <Message> messages;
    
    
    public Chanel() {
    }

    public Chanel(Long id, String name, String description) {
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

    @Override
    public String toString() {
        return "Chanel{" + "id=" + id + ", name=" + name + ", description=" + description +  '}';
    }

 
    
      
}
