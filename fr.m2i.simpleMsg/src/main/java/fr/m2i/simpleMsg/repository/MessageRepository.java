/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.repository;

import fr.m2i.simpleMsg.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RAISA
 */
public interface MessageRepository extends JpaRepository<Message, Long>{
    
}