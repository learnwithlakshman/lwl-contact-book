package com.lwl.cbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.cbook.dto.ContactDTO;
import com.lwl.cbook.service.ContactService;

@RestController
@RequestMapping("/api/cbook")
public class ContactController {

		private ContactService contactService;

		@Autowired
		public ContactController(ContactService contactService) {
			this.contactService = contactService;
		}
		@GetMapping("/all")
		public ResponseEntity<List<ContactDTO>> contacts(){
			List<ContactDTO> list = contactService.getContacts();
			return ResponseEntity.ok(list);
		}
		
		@PostMapping("/new")
		public ResponseEntity<ContactDTO> add(@RequestBody ContactDTO contactDto){
			contactDto = contactService.addContact(contactDto);
			return ResponseEntity.ok(contactDto);
		}
}
