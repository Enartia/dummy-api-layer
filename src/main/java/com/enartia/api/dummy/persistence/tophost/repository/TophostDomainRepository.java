package com.enartia.api.dummy.persistence.tophost.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enartia.api.dummy.persistence.tophost.entities.TophostDomainEntity;

@Repository
public interface TophostDomainRepository extends JpaRepository<TophostDomainEntity, Long> {

	Optional<TophostDomainEntity> findOneByDomainName(String domainName);
	
}
