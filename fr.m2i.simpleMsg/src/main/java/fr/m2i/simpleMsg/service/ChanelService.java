package fr.m2i.simpleMsg.service;

import fr.m2i.simpleMsg.model.Chanel;
import fr.m2i.simpleMsg.repository.ChanelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author RAISA
 */
@Service
public class ChanelService  implements IChanelService{
    
    private ChanelRepository repo;


    @Autowired
    public ChanelService(ChanelRepository repo) {
        this.repo = repo;
    }
    
    
    public List <Chanel> findAllChanels(){
        return null;
    }
    
    public Chanel findChanelById(){
          return null;
    }
    
    public Chanel updateChanel(){
          return null;
    }
    
    public void deleteChanel(){
        
    }
    
    public Chanel createChanel(){
      return null;
}
    
}
