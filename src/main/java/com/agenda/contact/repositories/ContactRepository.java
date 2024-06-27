package com.agenda.contact.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.contact.entities.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Integer>{
    
}
