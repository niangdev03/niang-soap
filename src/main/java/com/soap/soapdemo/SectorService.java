package com.soap.soapdemo;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

import com.soap.DAO.SectorDAO;
import com.soap.entity.Sector;

@WebService
public class SectorService {
    private SectorDAO dao = new SectorDAO();

    @WebMethod
    public String createSector(String name) {
        Sector sector = new Sector(0, name);
        dao.createSector(sector);
        return "Sector created: " + name;
    }

    @WebMethod
    public List<Sector> listSectors() {
        return dao.getAllSectors();
    }
}
