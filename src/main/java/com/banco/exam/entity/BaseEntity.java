package com.banco.exam.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.banco.exam.constants.Estado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Column
	private Boolean isActive;
	
	@CreationTimestamp
	@Column
	private LocalDateTime createdAt;
	@UpdateTimestamp
	@Column
	private LocalDateTime updatedAt;
	
	@PrePersist
	protected void onPersist() {
	    isActive = Estado.ACTIVE.getValue();
	}
}
