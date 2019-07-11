package com.enartia.api.dummy.api.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enartia.api.dummy.api.beans.DomainCreateRequest;
import com.enartia.api.dummy.api.beans.DomainUserList;
import com.enartia.api.dummy.services.DomainService;

@RestController
@Validated
@RequestMapping(path = "/domains", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DomainController {

	@Autowired
	private DomainService domainService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	@Secured({"ROLE_ADMIN"})
	public void createUserDomain(@AuthenticationPrincipal Principal user, @RequestBody @Valid DomainCreateRequest createDomainRequest) throws Exception {
		
		String domainName = createDomainRequest.getDomain().trim();
		
		if (!domainService.existsByDomainName(domainName))
			domainService.createUserDomain(user.getName(), domainName);
		else
			throw new Exception("Domain name already exists");//TODO: Customize Error
	}

	@GetMapping
	public DomainUserList getUserDomains(@AuthenticationPrincipal Principal user) {
		
		List<String> userDomains = domainService.getUserDomains(user.getName());
		
		return DomainUserList.builder()
				.domains(userDomains)
				.build();

	}
	
}
