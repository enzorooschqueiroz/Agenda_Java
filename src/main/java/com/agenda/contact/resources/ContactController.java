package com.agenda.contact.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agenda.contact.dto.ContactRequest;
import com.agenda.contact.dto.ContactResponse;
import com.agenda.contact.services.ContactService;

@RestController
@RequestMapping
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getContacts() {
        return ResponseEntity.ok(contactService.getContacts());
    }

    @GetMapping({"{id}"})
    public ResponseEntity<ContactResponse> geContactById(@PathVariable int id){
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<ContactResponse>> getFavoriteContacts(){
        return ResponseEntity.ok(contactService.getFavoriteContacts());
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteContactById(@PathVariable int id){
        this.contactService.deleteContactById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ContactResponse> save(@Validated @RequestBody ContactRequest contact){
        ContactResponse newContact = this.contactService.save(contact);

        URI location = ServletUriComponentsBuilder.
                                fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(newContact.id())
                                .toUri();

        return ResponseEntity.created(location).body(newContact);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @Validated @RequestBody ContactRequest contact){
        this.contactService.update(id, contact);
        return ResponseEntity.ok().build();
    }
}
