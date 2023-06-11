package com.demo.swagger.controller;

import com.demo.swagger.model.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    ConcurrentMap<String, Contact> contactsMap = new ConcurrentHashMap<>();

    @GetMapping("/")
    @ApiOperation(value = "Get All contacts", notes = "Get all available contacts",
    response = List.class)
    public List<Contact> getAllContacts() {
        return contactsMap.values().stream().collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find contacts by Id", notes = "provide id to find latest contact by Id",
            response = Contact.class)
    public Contact getContactById(@ApiParam(value = "ID value for the contact you need to retrieve", required = true) @PathVariable String id) {
        return contactsMap.get(id);
    }

    @PostMapping("/")
    @ApiOperation(value = "add a contact", notes = "provide contact to add",
            response = Contact.class)
    public Contact addContact(@RequestBody Contact contact) {
        contactsMap.put(contact.getId(), contact);
        return contact;
    }
}
