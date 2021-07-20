package com.exampleconnexion.connexion.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utilisateur")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Utilisateur extends MainEntity {

    @Column(unique = true)
    private String email;

    private String password;
    private String firstName;
    private String lastName;
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER) /*FetchType.EAGER  VS FetchType.LAZY*/
    @JoinTable(name = "user_roles",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role){
        this.roles.add(role);
        //Quand il est appelé hors de la classe comment on fais pour avoir la liste des roles
    }
    public void removeRole(Role role){
        this.roles.remove(role);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
