/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.simpleMsg.response;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
/**
 *
 * @author RAISA
 */
public class ErrorResponse {
    
   private Calendar calendar;
    private String error;
    private int status;
    private String path;

    public ErrorResponse(String error, int status, String path) {
        this.calendar = Calendar.getInstance();
        this.error = error;
        this.status = status;
        this.path = path;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
