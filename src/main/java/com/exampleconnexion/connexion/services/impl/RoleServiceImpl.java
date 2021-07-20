package com.exampleconnexion.connexion.services.impl;

import com.exampleconnexion.connexion.dto.RoleDto;
import com.exampleconnexion.connexion.entity.Role;
import com.exampleconnexion.connexion.repository.RoleRepository;
import com.exampleconnexion.connexion.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        return RoleDto.fromEntity(
                roleRepository.save(
                        RoleDto.toEntity(roleDto)
                )
        );
    }

    @Override
    public RoleDto findById(String id) {
        return null;
    }

    @Override
    public RoleDto findByRoleName(String roleName) {
        return null;
    }

    @Override
    public List<RoleDto> findAll() {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
