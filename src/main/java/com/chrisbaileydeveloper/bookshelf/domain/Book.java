package com.chrisbaileydeveloper.bookshelf.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * A Book.
 */

@Entity
@Table(name = "T_BOOK")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@NotEmpty
	@Size(min = 5, max = 100)
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@NotEmpty
	@Column(name = "publisher", nullable = false)
	private String publisher;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "date_of_publication")
	private DateTime dateOfPublication;

	@Column(name = "description")
	private String description;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "photo")
	private String photo;

	// Book constructor
	public Book(Integer version, String name, String publisher,
			DateTime dateOfPublication, String description, String photo) {
		this.version = version;
		this.name = name;
		this.publisher = publisher;
		this.dateOfPublication = dateOfPublication;
		this.description = description;
		this.photo = photo;
	}

	// No-arg book constructor.
	public Book() {
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public DateTime getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(DateTime dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Book book = (Book) o;

		if (!Objects.equals(id, book.id))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "Book{" + "id=" + id + ", version='" + version + "'"
				+ ", name='" + name + "'" + ", publisher='" + publisher + "'"
				+ ", dateOfPublication='" + dateOfPublication + "'"
				+ ", description='" + description + "'" + ", photo='" + photo
				+ "'" + '}';
	}

}
