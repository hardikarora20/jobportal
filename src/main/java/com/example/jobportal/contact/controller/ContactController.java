package com.example.jobportal.contact.controller;

import com.example.jobportal.contact.service.IContactService;
import com.example.jobportal.dto.ContactDto;
import com.example.jobportal.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private IContactService contactService;

    @Autowired
    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<String> saveContactMessage(@RequestBody ContactDto contactDto){
        boolean isSaved = contactService.saveContact(contactDto);
        if(isSaved)
            return ResponseEntity.status(201).body("Successfully Created!");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
    }

}