package com.exampleconnexion.connexion.services;

import com.exampleconnexion.connexion.dto.UtilisateurDto;
import com.exampleconnexion.connexion.entity.Utilisateur;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface UtilisateurService {
    Utilisateur save(Utilisateur utilisateur);

    UtilisateurDto create(UtilisateurDto userDto);

    UtilisateurDto findById(String id);

    UtilisateurDto findByEmail(String email);

    List<UtilisateurDto> findAll();

    void delete(String id);

    boolean existByEmail(String email);
}
