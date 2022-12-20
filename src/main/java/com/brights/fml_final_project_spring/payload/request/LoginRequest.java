package com.brights.fml_final_project_spring.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	@Getter
	@Setter
  private String username;

	@NotBlank
	@Getter
	@Setter
	private String password;
}
