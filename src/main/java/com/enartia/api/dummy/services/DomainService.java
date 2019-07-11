package com.enartia.api.dummy.services;

import java.util.List;

public interface DomainService {

	boolean existsByDomainName(String domainName);

	void createUserDomain(String username, String domainName);

	List<String> getUserDomains(String username);

}