package com.apiexample.Dto;

import java.util.Date;

public class ErrorDto {

    private Date date;
    private String message;
    private String url;
    public ErrorDto(Date date,String message, String url){
       this.message=message;
       this.date=date;
       this.url=url;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }
}
