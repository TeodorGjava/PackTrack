package com.mycompany.trackpackfirst;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LL
 */
class Vsichki {
    private String IDopakovka;
    private String Status;
    private String Location;
    private String datestamp;
    private String numWh;
    
    public Vsichki(String IDopakovka,String Status,String Location, String datestamp,String numWh){
    this.IDopakovka = IDopakovka;
    this.Status = Status;
    this.Location = Location;
    this.datestamp = datestamp;
    
    this.numWh = numWh;
    }
    public String getID(){
    return IDopakovka;
    }
    public String getStatus(){
    return Status;
    }
    public String getLocation(){
    return Location;
    }
    public String getdatestamp(){
    return datestamp;
    }
    
    public String getNumWh(){
    return numWh;
    }
    public String setID(String str){
    return str;
    }
    public String setStatus(String str){
    return str;
    }
    public String setLocation(String str){
    return str;
    }
    public String setdatestamp(String str){
    return str;
    }
    
    public String setNumWh(String str){
    return str;
    }
}
