package com.st.domain.salesforce;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "salesforce")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "lastChange", nullable = false)
	private Date lastChange;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param name
	 * @param lastChange
	 */
	public User(String name, Date lastChange) {
		super();
		this.name = name;
		this.lastChange = lastChange;
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
	 * @return the lastChange
	 */
	public Date getLastChange() {
		return lastChange;
	}

	/**
	 * @param lastChange
	 *            the lastChange to set
	 */
	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

}
