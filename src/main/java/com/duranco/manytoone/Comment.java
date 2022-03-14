package com.duranco.manytoone;

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

@Entity
public class Comment extends AuditModel {
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
	@JoinColumn(name = "post_id", nullable = false)
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


}
