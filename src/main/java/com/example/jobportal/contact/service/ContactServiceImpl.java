package com.example.jobportal.contact.service;

import com.example.jobportal.dto.ContactDto;
import com.example.jobportal.entity.Contact;
import com.example.jobportal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.Instant;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService{

    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public boolean saveContact(ContactDto contactDto) {
        Contact contact = contactRepository.save(transformIntoEntity(contactDto));
        return (contact != null || contact.getId() != null) ? true : false;
    }

//    we have received a dto but we have to save this into entity class or table
//    for that we have to receive the same thing that is entity class
//    for that we have to transform this dto into object

    private Contact transformIntoEntity(ContactDto contactDto){
        Contact contact = new Contact();
//        data will only be copied whose field name matches in both the source and target
        BeanUtils.copyProperties(contactDto, contact);
//        contact.setCreatedAt(LocalDateTime.now());
        return contact;
    }
}

