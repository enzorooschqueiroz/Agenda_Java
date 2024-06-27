package com.agenda.contact.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.contact.entities.Contact;
import com.agenda.contact.services.ContactService;

@RestController
@RequestMapping
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @GetMapping({"{id}"})
    public Contact geContactById(@PathVariable int id){
        return contactService.geContactById(id);
    }
    
    @DeleteMapping("{id}")
    public void deleteContactById(@PathVariable int id){
        this.contactService.deleteContactById(id);
    }

}
