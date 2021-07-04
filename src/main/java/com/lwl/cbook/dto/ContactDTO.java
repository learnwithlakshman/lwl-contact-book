package com.lwl.cbook.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {
	private Long id;
	private String name;
	private String email;
	private String mobile;
}
