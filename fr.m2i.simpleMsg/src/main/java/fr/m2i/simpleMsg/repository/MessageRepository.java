/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.repository;

import fr.m2i.simpleMsg.model.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author RAISA
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
    
          @Query(value="select u from Message u where  u.chanel.id= :id") 
          List<Message> getAllMessagesByChannel(@Param("id") Long id);
}
