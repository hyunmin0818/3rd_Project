package com.movie.web.dto;

public class DirectorDTO {
	private int directorId;
	private String director_name;
	private int birth_date;
	
	
	public int getDirector_id() {
		return directorId;
	}
	public void setDirector_id(int director_id) {
		this.directorId = director_id;
	}
	public String getName() {
		return director_name;
	}
	public void setName(String name) {
		this.director_name = name;
	}
	public int getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(int birth_date) {
		this.birth_date = birth_date;
	}
	
	
	
	
}