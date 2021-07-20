package com.exampleconnexion.connexion.security;

import com.exampleconnexion.connexion.entity.Utilisateur;
import com.exampleconnexion.connexion.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService { //Comment et à quel moment/niveau se service est appelé ???
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("user Not Found With -> email : "  + email)
        );
        return CustomUserDetails.build(utilisateur);
    }
}