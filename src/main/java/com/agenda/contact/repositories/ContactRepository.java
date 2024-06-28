package com.agenda.contact.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.contact.entities.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Integer>{
    List<Contact> findByFavoritoTrue();
}
