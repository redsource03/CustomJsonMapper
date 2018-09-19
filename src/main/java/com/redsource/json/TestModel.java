package com.redsource.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TestModel {
	@JsonMapAnnotation (loc = "profile.firstname")
	private String firstname;
	@JsonMapAnnotation (loc = "profile.address.city")
	private String city;
	@JsonMapAnnotation (loc = "profile.hobbies")
	private JSONArray hobbies;
	@JsonMapAnnotation(loc = "profile.age")
	private long age;
	@JsonMapAnnotation(loc = "profile.interest[0].name")
	private String firstInterest;
	@JsonMapAnnotation(loc = "profile.music")
	private JSONObject music;
	
	
	public JSONObject getMusic() {
		return music;
	}
	public void setMusic(JSONObject music) {
		this.music = music;
	}
	public String getFirstInterest() {
		return firstInterest;
	}
	public void setFirstInterest(String firstInterest) {
		this.firstInterest = firstInterest;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public JSONArray getHobbies() {
		return hobbies;
	}
	public void setHobbies(JSONArray hobbies) {
		this.hobbies = hobbies;
	}
	
	

}
