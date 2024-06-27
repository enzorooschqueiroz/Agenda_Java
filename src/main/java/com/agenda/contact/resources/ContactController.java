package com.agenda.contact.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.contact.entities.Contact;

@RestController
@RequestMapping
public class ContactController {

    @GetMapping
    public List<Contact> geContacts() {
        
        Contact c1 = new Contact();
        c1.setId(1);
        c1.setNome("Glauco");
        c1.setEmail("glauco@example.com");
        c1.setTelefone("123456789");
        c1.setEndereco("Rua Exemplo, 123");
        c1.setAniversario("1990-01-01");
        c1.setGenero("Masculino");
        c1.setCategoria("Amigos");
        c1.setFavorito(true);

        Contact c2 = new Contact();
        c2.setId(2);
        c2.setNome("Maria");
        c2.setEmail("maria@example.com");
        c2.setTelefone("987654321");
        c2.setEndereco("Avenida Exemplo, 456");
        c2.setAniversario("1985-05-20");
        c2.setGenero("Feminino");
        c2.setCategoria("Trabalho");
        c2.setFavorito(false);

        Contact c3 = new Contact();
        c3.setId(3);
        c3.setNome("Fernanda");
        c3.setEmail("fernanda@example.com");
        c3.setTelefone("5647382910");
        c3.setEndereco("Praça Exemplo, 789");
        c3.setAniversario("1992-03-15");
        c3.setGenero("Feminino");
        c3.setCategoria("Família");
        c3.setFavorito(true);

        List<Contact> lista = new ArrayList<>();
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);

        return lista;
        
        

    }
    
}
