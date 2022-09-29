/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg;

import fr.m2i.simpleMsg.service.IMessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 *
 * @author RAISA
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
  
    @MockBean
    private IMessageService messageService;
    
    
    @Test
    public void testGetMessagesByCanal() throws Exception {
        mockMvc.perform(get("/v1/messages/chanel/2")).andExpect(status().isOk());
    }
    
    
    @Test
    public void testGetMessageById() throws Exception {
         mockMvc.perform(get("/v1/messages/1")).andExpect(status().isOk());
    }
    
    
}
