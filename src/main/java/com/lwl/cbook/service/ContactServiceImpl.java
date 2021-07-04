package com.lwl.cbook.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.lwl.cbook.domain.Contact;
import com.lwl.cbook.dto.ContactDTO;
import com.lwl.cbook.repo.ContactRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

	private ContactRepo contactRepo;

	@Autowired
	public ContactServiceImpl(ContactRepo contactRepo) {
		this.contactRepo = contactRepo;
	}

	@Override
	public ContactDTO addContact(ContactDTO contactDTO) {
		Assert.notNull(contactDTO, "Contact can't be null or empty");
		Assert.notNull(contactDTO.getMobile(), "Mobile number can't be empty or null");
		Assert.notNull(contactDTO.getName(), "Name can't be empty or null");

		Contact contact = fromDTO(contactDTO);
		contact = contactRepo.save(contact);
		log.info("Contact is saved with id :{}", contact.getId());
		contactDTO = toDTO(contact);

		return contactDTO;
	}

	@Override
	public List<ContactDTO> getContacts() {

		List<Contact> list = contactRepo.findAll();
		log.info("Total {} contacts found", list.size());
		return list.stream().map(c -> toDTO(c)).collect(Collectors.toList());
	}

	private static Contact fromDTO(ContactDTO contactDTO) {
			Contact contact = Contact.builder().name(contactDTO.getName()).email(contactDTO.getEmail())
					.mobile(contactDTO.getMobile()).build();
					return contact;
	}

	private static ContactDTO toDTO(Contact contact) {
		ContactDTO contactDTO = ContactDTO.builder().id(contact.getId()).name(contact.getName())
				.email(contact.getEmail()).mobile(contact.getMobile()).build();
		return contactDTO;
	}

}
