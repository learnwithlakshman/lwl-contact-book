package com.lwl.cbook.service;

import java.util.List;

import com.lwl.cbook.dto.ContactDTO;

public interface ContactService {

		public ContactDTO addContact(ContactDTO contactDTO);
		public List<ContactDTO> getContacts();
}
