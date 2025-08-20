package com.soap.soapdemo;

import java.util.List;

import com.soap.DAO.ClasseDAO;
import com.soap.entity.Classe;
import com.soap.entity.Sector;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class ClasseService {
    private ClasseDAO dao = new ClasseDAO();


    public String createClasse(
        @WebParam(name = "name") String name,
        @WebParam(name = "description") String description,
        @WebParam(name = "sectorId") int sectorId
    ) {
        Sector sector = new Sector(sectorId, null);
        Classe classe = new Classe(0, name, description, sector);
        dao.createClasse(classe);
        return "Classe crée avec succès: " + name + " (sector_id=" + sectorId + ")";
    }

    @WebMethod
    public List<Classe> listClasses() {
        return dao.getAllClasses();
    }
}