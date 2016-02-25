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

	@Column(name = "_hc_err")
	private String _hc_err;

	@Column(name = "_hc_lastop")
	private String _hc_lastop;
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
	 * @param createddate
	 * @param name
	 * @param lastmodifieddate
	 * @param _hc_err
	 * @param _hc_lastop
	 */
	public Account(Date createddate, String name, Date lastmodifieddate, String _hc_err, String _hc_lastop) {
		super();
		this.createddate = createddate;
		this.name = name;
		this.lastmodifieddate = lastmodifieddate;
		this._hc_err = _hc_err;
		this._hc_lastop = _hc_lastop;
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

	/**
	 * @return the _hc_err
	 */
	public String get_hc_err() {
		return _hc_err;
	}

	/**
	 * @param _hc_err
	 *            the _hc_err to set
	 */
	public void set_hc_err(String _hc_err) {
		this._hc_err = _hc_err;
	}

	/**
	 * @return the _hc_lastop
	 */
	public String get_hc_lastop() {
		return _hc_lastop;
	}

	/**
	 * @param _hc_lastop
	 *            the _hc_lastop to set
	 */
	public void set_hc_lastop(String _hc_lastop) {
		this._hc_lastop = _hc_lastop;
	}
	

}
