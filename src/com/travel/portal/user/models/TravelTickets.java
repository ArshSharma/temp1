package com.travel.portal.user.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.travel.portal.user.constants.Constants;

@Entity
@Table(name="tickets")
public class TravelTickets {
	
	@Id
	@GeneratedValue
	@Column(name=Constants.TICKET_ID)
	private int ticketId;
	@Column(name=Constants.REQUEST_TYPE)
	private String requestType;
	@Column(name=Constants.PRIORITY)
	private String priority;
	@Column(name=Constants.TRAVEL_CITY)
	private String travelCity;
	@Column(name=Constants.LOCATION)
	private String locationCity;
	@Column(name = Constants.TRAVEL_START_DATE)
	private LocalDate travelStartDate;
	@Column(name = Constants.TRAVEL_END_DATE)
	private LocalDate travelEndDate;
	@Column(name = Constants.PASSPORT)
	private String passportNo;
	@Column(name=Constants.PROJECT_NAME)
	private String projectName;
	@Column(name=Constants.EXPENSES_BORNE_BY)
	private String expensesBy;
	@Column(name=Constants.TRAVEL_APPROVER)
	private String travelApprover;
	@Column(name=Constants.EXPECTED_DURATION)
	private String expectedDuration;
	@Column(name=Constants.UPPER_BOUND)
	private String upperBound;
	@Column(name=Constants.DETAILS)
	private String details;
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private UserRegistration user;
	@Column(name=Constants.STATUS)
	private String status;
	@Column(name=Constants.SUBMISSION_DATE)
	private LocalDate submission_date;
	//Getters and Setters
	
	public int getTicketId() {
		return ticketId;
	}
	public String getExpectedDuration() {
		return expectedDuration;
	}
	public void setExpectedDuration(String expectedDuration) {
		this.expectedDuration = expectedDuration;
	}
	public String getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(String upperBound) {
		this.upperBound = upperBound;
	}
	public UserRegistration getUser() {
		return user;
	}
	public void setUser(UserRegistration user) {
		this.user = user;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getSubmission_date() {
		return submission_date;
	}
	public void setSubmission_date(LocalDate submission_date) {
		this.submission_date = submission_date;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getTravelCity() {
		return travelCity;
	}
	public void setTravelCity(String travelCity) {
		this.travelCity = travelCity;
	}
	public String getLocationCity() {
		return locationCity;
	}
	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}
	public LocalDate getTravelStartDate() {
		return travelStartDate;
	}
	public void setTravelStartDate(String travelStartDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.travelStartDate = LocalDate.parse(travelStartDate, dtf);
	}
	public LocalDate getTravelEndDate() {
		return travelEndDate;
	}
	public void setTravelEndDate(String travelEndDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.travelEndDate = LocalDate.parse(travelEndDate, dtf);
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getExpensesBy() {
		return expensesBy;
	}
	public void setExpensesBy(String expensesBy) {
		this.expensesBy = expensesBy;
	}
	public String getTravelApprover() {
		return travelApprover;
	}
	public void setTravelApprover(String travelApprover) {
		this.travelApprover = travelApprover;
	}
	public String getDuration() {
		return expectedDuration;
	}
	public void setDuration(String duration) {
		this.expectedDuration = duration;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
}
