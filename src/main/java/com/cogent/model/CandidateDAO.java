/**
 * @author: Anvar Szulczyk
 * @date: Feb 5, 2024
 */
package com.cogent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CandidateDAO {
	private int id;
	private String name;
	private String email;
	private double rating;
	
	/**
	 * 
	 */
	public CandidateDAO() {
		super();
	}
	/**
	 * @param name
	 * @param email
	 * @param rating
	 */
	public CandidateDAO(int id, String name, String email, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.rating = rating;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CandidateDAO [id=" + id + ", name=" + name + ", email=" + email + ", rating=" + rating + "]";
	}

}
