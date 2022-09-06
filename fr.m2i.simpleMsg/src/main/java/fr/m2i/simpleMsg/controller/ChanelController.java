/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.controller;


import fr.m2i.simpleMsg.dto.ChanelDTO;
import fr.m2i.simpleMsg.dto.ChanelMapper;
import fr.m2i.simpleMsg.exception.NotFoundException;
import fr.m2i.simpleMsg.model.Chanel;
import fr.m2i.simpleMsg.response.ErrorResponseEntity;
import fr.m2i.simpleMsg.service.IChanelService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author RAISA
 */
@RestController
@RequestMapping("/v1/chanels")
public class ChanelController {

    private final IChanelService chanelService;

    public ChanelController(IChanelService chanelService) {
        this.chanelService = chanelService;
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllChanel() {

        List<Chanel> chanels = chanelService.findAllChanels();
        List<ChanelDTO> dtos = new ArrayList();

        for (Chanel chanel : chanels) {
            ChanelDTO dto = ChanelMapper.buildChanelDTO(chanel);
            dtos.add(dto);
        }

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //Find chanel by id
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getChanelById(@PathVariable("id") String id) {
        try {
            Long chanelId = Long.parseLong(id);
            Chanel founded = chanelService.findChanelById(chanelId);
            ChanelDTO dto = ChanelMapper.buildChanelDTO(founded);

            return ResponseEntity.status(HttpStatus.OK).body(dto);

        } catch (NumberFormatException ne) {
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/chanels/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Chanel was not found", 404, "/v1/chanels/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/chanels/" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Create a new chanel
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> createChanel(@RequestBody ChanelDTO dto) {
        try {
            Chanel toCreate = ChanelMapper.buildChanel(dto);
            Chanel created = chanelService.createChanel(toCreate);
            ChanelDTO createdDTO = ChanelMapper.buildChanelDTO(created);

            return ResponseEntity.status(HttpStatus.OK).body(createdDTO);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ErrorResponseEntity.build("An error occured", 500, "/v1/chanels", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update chanel informations like name or description 
    @PutMapping(
            value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
     public ResponseEntity<Object> updateChanel(@PathVariable("id") String id,
            @RequestBody ChanelDTO dto) {
        
        try {
            Long chanelId = Long.parseLong(id);
            Chanel toUpdate = ChanelMapper.buildChanel(dto);
            Chanel updated = chanelService.updateChanel(chanelId, toUpdate);
            ChanelDTO updatedDTO = ChanelMapper.buildChanelDTO(updated);

            return ResponseEntity.status(HttpStatus.OK).body(updatedDTO);

        } catch (NumberFormatException ne) {
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/chanels/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Chanel was not found", 404, "/v1/chanels/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/chanels/" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     
     //Remove a chanel with associated messages
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteChanel(@PathVariable("id") String id) {
        try {
            Long chanelId = Long.parseLong(id);
            chanelService.deleteChanel(chanelId);

            return new ResponseEntity<>("The Message have been successfully removed", HttpStatus.OK);

        } catch (NumberFormatException ne) {
            return ErrorResponseEntity.build("The parameter 'id' is not valid", 400, "/v1/chanels/" + id, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException nfe) {
            return ErrorResponseEntity.build("Chanel was not found", 404, "/v1/chanels/" + id, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ErrorResponseEntity.build("An error occured", 500, "/v1/chanels/" + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
