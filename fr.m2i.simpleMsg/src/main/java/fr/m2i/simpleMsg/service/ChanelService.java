package fr.m2i.simpleMsg.service;

import fr.m2i.simpleMsg.dto.ChanelMapper;
import fr.m2i.simpleMsg.exception.NotFoundException;
import fr.m2i.simpleMsg.model.Chanel;
import fr.m2i.simpleMsg.repository.ChanelRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
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
    
    @Override
    public List <Chanel> findAllChanels(){
        return repo.findAll();
    }
    
    @Override
    public Chanel findChanelById(Long id){
        Chanel founded =repo.findById(id).orElseThrow(
                () -> new NotFoundException("Chanel with id: " + id + " was not found"));
        return founded;
    }
    
    @Override
    @Transactional
    public Chanel updateChanel(Long id, Chanel content){
        Chanel chanelToUpdate = findChanelById(id);
        chanelToUpdate = ChanelMapper.copy(chanelToUpdate, content);
          return repo.save(chanelToUpdate);
    }
    
    @Override
    @Transactional
    public void deleteChanel(Long id){
        Chanel chanel = findChanelById(id);
        repo.delete(chanel);
    }
    
    @Override
    @Transactional
    public Chanel createChanel(Chanel chanel){
      return repo.save(chanel);
}
    
 
    
}
