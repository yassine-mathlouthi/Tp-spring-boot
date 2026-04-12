package com.example.demo.service;

import com.example.demo.entity.Chambre;
import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre retrieveChambre(Long chambreId);
    Chambre addChambre(Chambre c);
    void removeChambre(Long chambreId);
    Chambre modifyChambre(Chambre c);
}
