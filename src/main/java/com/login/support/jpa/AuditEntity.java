package com.login.support.jpa;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.login.app.auth.entity.AuthenticationContext;
import com.login.app.metadata.domain.model.user.User;
import com.login.app.metadata.domain.service.UserAuthentication;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners({AuditingEntityListener.class})
@Data
public class AuditEntity {

	@CreatedDate
	@Column(name = "create_dtm", updatable = false)
	@Schema(description = "생성일시")
	protected LocalDateTime regDtm;

	@Column(name = "create_user_id", updatable = false)
	@Schema(description = "생성사용자Id")
	protected String regUserId;

	@Column(name = "create_user_nm", updatable = false)
	@Schema(description = "생성사용자이름")
	protected String regEmpNm;

	@LastModifiedDate
	@Column(name = "last_update_dtm")
	@Schema(description = "최종업데이트일시")
	protected LocalDateTime modDtm;

	@Column(name = "last_update_user_id")
	@Schema(description = "최종업데이트사용자Id")
	protected String modUserId;

	@Column(name = "last_update_user_nm")
	@Schema(description = "최종업데이트사용자이름")
	protected String modUserNm;

	/**
	 * @CreatedBy,@LastModifiedBy annotation 사용 시 AuditorAware 구현하여 auditor 가져올 수 있으나
	 * AuditorAware에서 Employee 객체 형태로 DB에 넣을 수 없어 PrePersist, PreUpdate 사용
	 * Cloud 환경의 확장성 및 연계성을 위해 localDateTime 은 'UCT'로 고정하였으나 Core와 연계를 위해 KST로 변경함
	 */
	@PrePersist
	protected void createdBy() {
		User user = AuthenticationContext.getCurrentEmployee()
			.orElse(new User());
		this.regUserId = user.getUserId();
		this.regEmpNm = user.getUserNm();
		this.modUserId = user.getUserId();
		this.modUserNm = user.getUserNm();
	}

	@PreUpdate
	private void lastModifiedBy() {
		User user = AuthenticationContext.getCurrentEmployee()
			.orElse(new User());
		this.modUserId = user.getUserId();
		this.modUserNm = user.getUserNm();
	}
}
