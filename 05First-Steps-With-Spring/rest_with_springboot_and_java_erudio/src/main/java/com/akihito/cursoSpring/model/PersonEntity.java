package com.akihito.cursoSpring.model;

import java.io.Serializable;
import java.util.Objects;

public class PersonEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String firstName;
	private String lastName;
	private String adrres;
	private String genre;

	public PersonEntity() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdrres() {
		return adrres;
	}

	public void setAdrres(String adrres) {
		this.adrres = adrres;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adrres, firstName, genre, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonEntity other = (PersonEntity) obj;
		return Objects.equals(adrres, other.adrres) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(genre, other.genre) && id == other.id && Objects.equals(lastName, other.lastName);
	}
	
	
}

