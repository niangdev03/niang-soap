package com.soap.soapdemo;

import java.util.List;

import com.soap.DAO.SectorDAO;
import com.soap.entity.Sector;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class SectorService {
    private SectorDAO dao = new SectorDAO();

    @WebMethod
    public String createSector(String name) {
        Sector sector = new Sector(0, name);
        dao.createSector(sector);
        return "Secteur crée avec succes : " + name;
    }

    @WebMethod
    public List<Sector> listSectors() {
        return dao.getAllSectors();
    }

    @WebMethod
    public String updateSector(int id, String name) {
        Sector sector = new Sector(id, name);
        dao.updateSector(sector);
        return "Secteur mis à jour avec succes : " + name + " (id=" + id + ")";
    }

    @WebMethod
    public String deleteSector(@WebParam(name = "id") int id) {
        System.out.println("ID reçu : " + id);
        boolean success = dao.deleteSector(id);
        if (success) {
            return "Secteur supprimé (id=" + id + ")";
        } else {
            return "Erreur suppression secteur (id=" + id + ")";
        }
    }
    
}
