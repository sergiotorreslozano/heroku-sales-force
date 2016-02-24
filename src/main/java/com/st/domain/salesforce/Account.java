package com.st.domain.salesforce;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "salesforcedev")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "createddate", nullable = false)
	private Date createddate;

	@Column(name = "name", nullable = false)
	private String name;
	
	
	@Column(name = "lastmodifieddate")
	private Date lastmodifieddate;

	/**
	 * 
	 */
	public Account() {
		super();
	}

	/**
	 * @param name
	 */
	public Account(String name, Date createddate) {
		super();
		this.name = name;
		this.createddate = createddate;
	}

	/**
	 * @param createddate
	 * @param name
	 * @param lastmodifieddate
	 */
	public Account(Date createddate, String name, Date lastmodifieddate) {
		super();
		this.createddate = createddate;
		this.name = name;
		this.lastmodifieddate = lastmodifieddate;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the createddate
	 */
	public Date getCreateddate() {
		return createddate;
	}

	/**
	 * @param createddate
	 *            the createddate to set
	 */
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastmodifieddate
	 */
	public Date getLastmodifieddate() {
		return lastmodifieddate;
	}

	/**
	 * @param lastmodifieddate
	 *            the lastmodifieddate to set
	 */
	public void setLastmodifieddate(Date lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}
	

}
