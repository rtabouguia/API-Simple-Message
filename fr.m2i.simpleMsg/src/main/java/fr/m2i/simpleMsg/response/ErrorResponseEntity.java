/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author RAISA
 */
public class ErrorResponseEntity {
    
    public static ResponseEntity<Object> build(String error, int status, String path, HttpStatus httpStatus){
        return new ResponseEntity<>(
                    new ErrorResponse(error, status, path),
                    new HttpHeaders(),
        httpStatus
        );
    }
}
