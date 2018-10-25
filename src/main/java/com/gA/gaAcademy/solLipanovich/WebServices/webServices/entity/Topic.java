package com.gA.gaAcademy.solLipanovich.WebServices.webServices.entity;

import java.util.Date;
//si modifico algo de una entidad debo parar el servidor y volver a ejecutar para que cree bien la tabla en la DB

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topic {

	// id
	@Id // al asumir que es una primary key ya crea la columna, no necesito @Column
	@GeneratedValue
	private int id;
	// title
	@Column(name = "title")
	private String title;
	// datePost
	@Column(name = "date")
	private Date datePost;
	// description
	@Column(name = "description")
	private String description;
	// author
	@Column(name = "author")
	private int authorId;

	public Topic() {

	}

	public Topic(String title, Date datePost, String description, int authorId) {
		super();
		this.title = title;
		this.datePost = new Date();
		this.description = description;
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getId() {
		return id;
	}

}
