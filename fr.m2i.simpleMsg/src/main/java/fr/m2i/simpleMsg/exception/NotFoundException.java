/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.exception;

/**
 *
 * @author RAISA
 */
public class NotFoundException extends RuntimeException {
    
     public NotFoundException() {
        super("Ressource was not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
