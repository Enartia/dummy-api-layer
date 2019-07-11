package com.enartia.api.dummy.api.beans;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DomainCreateRequest {
	
	@JsonProperty(value="domain")
	@NotBlank
	private String domain;

}
