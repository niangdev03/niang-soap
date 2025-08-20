package com.soap.soapdemo;

import jakarta.xml.ws.Endpoint;

public class SoapServer {
    public static void main(String[] args) {
        String url = "http://localhost:8080/ws/sector";
        Endpoint.publish(url, new SectorService());
        System.out.println("SOAP est en cours " + url + "?wsdl");
    }
}