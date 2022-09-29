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
 * IChanelService permet de faire les transactions avec la table chanel
 */

public interface IChanelService {
    
    //Récupère tous les chanels en base
      public List <Chanel> findAllChanels();
    
      //Récupère un chanel selon l'id fourni
      public Chanel findChanelById(Long id);
      
      //Mise à jour d'un chanel
      public Chanel updateChanel(Long id, Chanel content);
      
      //Cree un nouveau chanel
      public Chanel createChanel(Chanel chanel);
      
      //Supprime un chanel
      public void deleteChanel(Long id);
}
