package com.mycompany.trackpackfirst;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LL
 */
class Comments {
    private String id;
    private String comment;
    private String date;
    
    public Comments(String id, String comment, String date){
    this.comment=comment;
    this.date=date;
    this.id=id;
    }
    public String getId(){
    return id;
}
public String getComment(){
return comment;}
public String getDate(){
return date;}
        }
   
