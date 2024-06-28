package com.agenda.contact.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<Contact>> getContacts() {
        return ResponseEntity.ok(contactService.getContacts());
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Contact> geContactById(@PathVariable int id){
        return ResponseEntity.ok(contactService.geContactById(id));
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Contact>> getFavoriteContacts(){
        return ResponseEntity.ok(contactService.getFavoriteContacts());
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContactById(@PathVariable int id){
        this.contactService.deleteContactById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact){
        return this.contactService.save(contact);
    }
    
    @PutMapping("{id}")
    public void update(@PathVariable int id, @RequestBody Contact contact){
        this.contactService.update(id, contact);
    }
}
