package com.exampleconnexion.connexion.services;

import com.exampleconnexion.connexion.dto.RoleDto;
import com.exampleconnexion.connexion.entity.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);

    RoleDto createRole(RoleDto roleDto);

    RoleDto findById(String id);

    RoleDto findByRoleName(String roleName);

    List<RoleDto> findAll();

    void delete(String id);
}
