package com.exampleconnexion.connexion.dto;

import com.exampleconnexion.connexion.entity.Utilisateur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurDto {
    private String password;
    private String firstName;
    private String lastName;
    private String avatar;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }

        return UtilisateurDto.builder()
                .password(utilisateur.getPassword())
                .firstName(utilisateur.getFirstName())
                .lastName(utilisateur.getLastName())
                .avatar(utilisateur.getAvatar())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null){
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPassword(utilisateurDto.getPassword());
        utilisateur.setFirstName(utilisateurDto.getFirstName());
        utilisateur.setLastName(utilisateurDto.getLastName());
        utilisateur.setAvatar(utilisateurDto.getAvatar());
        return utilisateur;
    }
}
