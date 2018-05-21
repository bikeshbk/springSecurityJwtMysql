package com.springSecutiry.jwtWithMysql.repository;

import com.springSecutiry.jwtWithMysql.enums.RoleName;
import com.springSecutiry.jwtWithMysql.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByName(RoleName roleName);
}
