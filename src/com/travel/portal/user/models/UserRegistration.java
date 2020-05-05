package com.travel.portal.user.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.portal.user.constants.Constants;
/**
 * This is a user registration entity
 * which contains all the information as of to get the 
 * user registered.
 * This entity also acts a table in database with same column names
 * and other specifications
 * @author bhavneetkaur
 *
 */
@Entity
@Table(name = Constants.TABLE_NAME)
public class UserRegistration {

	@Id
	@GeneratedValue
	@Column(name=Constants.USER_ID)
	private int id;
	@Column(name=Constants.FIRST_NAME)
	private String firstname;
	@Column(name=Constants.LAST_NAME)
	private String lastname;
	@Column(name=Constants.BUSINESS_UNIT)
	private String businessUnit;
	@Column(name=Constants.EMAIL)
	private String email;
	@Column(name=Constants.CONTACT_NO)
	private String contactNo;
	@Column(name=Constants.ADDRESS)
	private String address;
	@Column(name=Constants.COUNTRY)
	private String country;
	// provide the list of cities with nagarros offices
	@Column(name=Constants.CITY)
	private String city;
	@Column(name="state")
	private String state;
	@Column(name=Constants.ZIP)
	private int zip;
	@Column(name=Constants.USERNAME)
	private String username;
	@Column(name=Constants.PASSWORD)
	private String password;
	@Column(name=Constants.DESIGINATION)
	private String desigination;
	@OneToMany(mappedBy="user")
	@JsonIgnore
    private List<TravelTickets> tickets;
	
	//Getters and Setters
	
	public List<TravelTickets> getTickets() {
		return tickets;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTickets(List<TravelTickets> tickets) {
		this.tickets = tickets;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesigination() {
		return desigination;
	}

	public void setDesigination(String desigination) {
		this.desigination = desigination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

}
