package com.enartia.api.dummy.api.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class DomainUserList {

	@JsonProperty(value="domains")
	private List<String> domains;
	
}
