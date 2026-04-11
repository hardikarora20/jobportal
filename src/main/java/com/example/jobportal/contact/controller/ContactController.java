package com.example.jobportal.contact.controller;

import com.example.jobportal.contact.service.IContactService;
import com.example.jobportal.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:5500")
@Validated
public class ContactController {

    private IContactService contactService;

    @Autowired
    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<String> saveContactMessage(@RequestBody @Valid ContactDto contactDto){
        boolean isSaved = contactService.saveContact(contactDto);
        if(isSaved)
            return ResponseEntity.status(201).body("Successfully Created!");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed");
    }

    @GetMapping("/sayhello")
    public ResponseEntity<String> fetchOpenContacts(
            @RequestParam
            @NotBlank(message = "cannot be blank")
            @Size(min = 4, message = "size should be more than 4 characters")
            String status) {
        return ResponseEntity.ok("Some data was sent in request: " + status);
    }
}