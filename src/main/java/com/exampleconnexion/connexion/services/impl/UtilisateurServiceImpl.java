package com.exampleconnexion.connexion.services.impl;

import com.exampleconnexion.connexion.dto.UtilisateurDto;
import com.exampleconnexion.connexion.entity.Utilisateur;
import com.exampleconnexion.connexion.repository.UtilisateurRepository;
import com.exampleconnexion.connexion.services.UtilisateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public UtilisateurDto create(UtilisateurDto userDto) {
        return null;
    }

    @Override
    public UtilisateurDto findById(String id) {
        return null;
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return null;
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return null;
    }

    @Override
    public void delete(String id) { }

    @Override
    public boolean existByEmail(String email) {
        return this.utilisateurRepository.existsByEmail(email);
    }
}
