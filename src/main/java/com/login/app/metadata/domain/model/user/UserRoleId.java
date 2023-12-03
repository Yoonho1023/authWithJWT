package com.login.app.metadata.domain.model.user;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleId implements Serializable {
	@Id
	@EqualsAndHashCode.Include
	@Column(name = "emp_no")
	private String empNo;

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "role_cd")
	private String roleCd;

}

