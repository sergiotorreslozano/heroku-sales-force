package com.st.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.domain.salesforce.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	/**
	 * deletes an account with the given name
	 * 
	 * @param name
	 *            name of the account to delete
	 * @return the number of rows deleted
	 */
	Integer deleteByName(String name);

	List<Account> findByLastmodifieddateAfter(Date lastmodifieddate);

	/**
	 * List of accounts created after createddate param
	 * 
	 * @param createddate
	 *            date to search for accounts
	 * @return List of accounts
	 */
	List<Account> findByCreateddateAfter(Date createddate);

}
