/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.service;

import fr.m2i.simpleMsg.model.Chanel;
import java.util.List;

/**
 *
 * @author RAISA
 */
public interface IChanelService {
    
      public List <Chanel> findAllChanels();
    
      public Chanel findChanelById();
      
      public Chanel updateChanel();
      
      public void deleteChanel();
}
