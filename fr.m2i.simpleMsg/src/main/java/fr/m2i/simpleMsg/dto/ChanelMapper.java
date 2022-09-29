/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.dto;

import fr.m2i.simpleMsg.model.Chanel;

/**
 *
 * @author RAISA
 */

public class ChanelMapper {
    
    public static ChanelDTO buildChanelDTO(Chanel chanel){
        
        if (chanel == null){
            return new ChanelDTO();
        }
        
        return new ChanelDTO(
                chanel.getId(),
                chanel.getName(),
                chanel.getDescription()
        );
    }
    public static Chanel buildChanel(ChanelDTO dto){
        if(dto == null){
            return null;
        }
        
        return new Chanel(
                dto.getId(),
                dto.getName(),
                dto.getDescription());
    }
    
    //copier les informaitions de correction dans le canal déjà existant pou rle modifier
    public static Chanel copy(Chanel chanel, Chanel content){
            if(chanel ==null || content == null){
                return null;
            }
            
            if (content.getName() != null){
                chanel.setName(content.getName());
            }
            
            if(content.getDescription() != null){
                chanel.setDescription(content.getDescription());
            }
            
            return chanel;
    }
    
}
