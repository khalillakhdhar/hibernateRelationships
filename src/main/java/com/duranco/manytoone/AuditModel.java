package com.duranco.manytoone;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
		value = {"createdAt","updatedAt"},
		allowGetters = true
		)
// ignorer les valeur de created et update 
// il faut rajouter mais autoriser la lecture des paramètres


public abstract class AuditModel implements Serializable // permet de lire la date sous forme de chaine  
{ 

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true, updatable = false)
	@CreatedDate // récupération de la date auto de création d'instance
	private Date createdAt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	@LastModifiedDate // récupération de la date auto de la derniere modification d'instance
	private Date updatedAt;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
