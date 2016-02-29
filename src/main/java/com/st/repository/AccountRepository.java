package com.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.domain.salesforce.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Integer deleteByName(String name);

}
