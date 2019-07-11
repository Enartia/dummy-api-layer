package com.enartia.api.dummy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.enartia.api.dummy.persistence.tophost.entities.TophostDomainEntity;
import com.enartia.api.dummy.persistence.tophost.entities.TophostUserEntity;
import com.enartia.api.dummy.persistence.tophost.repository.TophostDomainRepository;
import com.enartia.api.dummy.persistence.tophost.repository.TophostUserRepository;

@Service
@ConditionalOnProperty(name = "app.brand", havingValue = "tophost")
public class TophostDomainServiceImpl implements DomainService {

	@Autowired
	private TophostUserRepository tophostUserRepo;
	
	@Autowired
	private TophostDomainRepository tophostDomainRepo;

	public boolean existsByDomainName(String domainName) {
		return tophostDomainRepo.findOneByDomainName(domainName).isPresent();
	}
	
	public void createUserDomain(String username, String domainName) {
		
		TophostUserEntity userEntity = tophostUserRepo.findOneByUsername(username)
														.orElseThrow(() -> new UsernameNotFoundException("No user found with username " + username));
		
		TophostDomainEntity domainEntity = new TophostDomainEntity();
		domainEntity.setDomainName(domainName);
		domainEntity.setAdminUser(userEntity);
		tophostDomainRepo.save(domainEntity);
	}

	public List<String> getUserDomains(String username){

		Optional<TophostUserEntity> user = tophostUserRepo.findOneByUsername(username);

		if(user.isPresent()) {
			return user.get().getDomains()
					.stream()
					.map(i -> i.getDomainName())
					.collect(Collectors.toList());
		} else {
			return new ArrayList<>();
		}
	}

}
