package com.st.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.domain.salesforce.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
