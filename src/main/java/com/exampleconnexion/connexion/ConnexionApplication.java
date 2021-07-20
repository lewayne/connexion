package com.exampleconnexion.connexion;

import com.exampleconnexion.connexion.controller.TestController;
import com.exampleconnexion.connexion.entity.Role;
import com.exampleconnexion.connexion.entity.Utilisateur;
import com.exampleconnexion.connexion.services.RoleService;
import com.exampleconnexion.connexion.services.UtilisateurService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ConnexionApplication implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(ConnexionApplication.class);


	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UtilisateurService utilisateurService;

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(ConnexionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		//create a default User
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setFirstName("Merlin");
		utilisateur.setLastName("WANE");
		utilisateur.setEmail("wanefkdd@gmail.com");
		utilisateur.setPassword(passwordEncoder.encode("password"));

		Role role1 = roleService.save(new Role("ADMIN", "Administrator rule"));
		Role role2 = roleService.save(new Role("OTHER", "Other rule"));

		utilisateur.addRole(role1);
		utilisateur.addRole(role2);


		if(!utilisateurService.existByEmail(utilisateur.getEmail())){
			utilisateurService.save(utilisateur);
		}
		else{
			logger.error("user existe déja" + utilisateur);
		}

	}
}
