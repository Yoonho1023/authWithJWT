package com.login.app.metadata.domain.model.user;

import com.login.support.jpa.AuditEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@Table(name = "user_role")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(UserRoleId.class)
public class UserRole extends AuditEntity {

	@Id
	@Column(name = "emp_no")
	@Schema(description = "사원번호")
	private String empNo;

	@Id
	@Column(name = "role_cd")
	@Schema(description = "권한코드")
	private String roleCd;

	@Column(name = "use_yn")
	@Schema(description = "사용여부")
	private String useYn;

	@Column(name = "apply_start_dt")
	@Schema(description = "적용시작일자")
	private String applyBeginDt;

	@Column(name = "apply_end_dt")
	@Schema(description = "적용종료일자")
	private String applyEndDt;
}
