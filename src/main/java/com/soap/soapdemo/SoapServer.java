package com.soap.soapdemo;

import jakarta.xml.ws.Endpoint;

public class SoapServer {
    public static void main(String[] args) {
        String urlSector = "http://localhost:8080/ws/sector";
        Endpoint.publish(urlSector, new SectorService());
        System.out.println("SOAP Sector est en cours " + urlSector + "?wsdl");

        String urlClasse = "http://localhost:8080/ws/classe";
        Endpoint.publish(urlClasse, new ClasseService());
        System.out.println("SOAP Classe est en cours " + urlClasse + "?wsdl");
    }
}