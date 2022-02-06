package com.mycompany.trackpackfirst;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LL
 */
class Clients {
    private String IDopakovka;
    private String Status;
    private String Location;
    private String datestamp;
    
    private String numWh;
    public Clients(String IDopakovka,String Status,String Location, String datestamp, String numWh){
    this.IDopakovka = IDopakovka;
    this.Status = Status;
    this.Location = Location;
    this.datestamp = datestamp;
    
    this.numWh=numWh;
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
}

