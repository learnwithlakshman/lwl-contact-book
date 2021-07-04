package com.lwl.cbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwl.cbook.domain.Contact;

public interface ContactRepo extends JpaRepository<Contact,Long> {

}
