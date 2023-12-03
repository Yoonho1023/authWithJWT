package com.login.app.metadata.domain.model.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {

	Optional<UserRole> findTop1ByEmpNoAndUseYnIs(String empNo, String useYn);

}
