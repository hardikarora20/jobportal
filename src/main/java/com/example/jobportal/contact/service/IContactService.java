package com.example.jobportal.contact.service;

import com.example.jobportal.dto.ContactDto;

public interface IContactService {
    boolean saveContact(ContactDto contactDto);
}
