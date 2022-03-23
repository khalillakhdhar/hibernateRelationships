package com.duranco.manytoone;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Comment extends AuditModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	@NotNull
	@Lob
private String texte;

// fetch lazy=> lecture unidrectionelle ( de comment=> post uniquement) eager=> lecture bidirectionelle
	@ManyToOne(fetch = FetchType.LAZY,optional = false) // fetch = mode de lecture
	// optional false=> la relation est obligatoire => un commentaire DOIT avoir une publication*
	// optional true=> on peu avoir des comm. sans publication
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "post_id")
	// serialisation manuelle
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("post_id")
	// lecture
	private Post post;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment() {
		super();
	}


}
