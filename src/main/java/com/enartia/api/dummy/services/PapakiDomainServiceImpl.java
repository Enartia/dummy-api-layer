package com.enartia.api.dummy.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.enartia.api.dummy.persistence.papaki.entities.PapakiDomainEntity;
import com.enartia.api.dummy.persistence.papaki.repository.PapakiDomainRepository;

@Service
@ConditionalOnProperty(name = "app.brand", havingValue = "papaki")
public class PapakiDomainServiceImpl implements DomainService {

	@Autowired
	private PapakiDomainRepository papakiRepo;

	public boolean existsByDomainName(String domainName) {
		return papakiRepo.findOneByDomainName(domainName).isPresent();
	}

	public void createUserDomain(String username, String domainName) {

		PapakiDomainEntity entity = new PapakiDomainEntity();
		entity.setAdminUser(username);
		entity.setDomainName(domainName);
		
		papakiRepo.save(entity);
	}
	
	public List<String> getUserDomains(String username){
		
		return papakiRepo.findByAdminUser(username)
				.stream()
				.map(i -> i.getDomainName())
				.collect(Collectors.toList());
	}
	
}
