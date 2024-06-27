package com.agenda.contact.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.contact.entities.Contact;
import com.agenda.contact.services.ContactService;

@RestController
@RequestMapping
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getContacts();
        

    }
    
}
