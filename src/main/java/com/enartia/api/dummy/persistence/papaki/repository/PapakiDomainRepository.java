package com.enartia.api.dummy.persistence.papaki.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enartia.api.dummy.persistence.papaki.entities.PapakiDomainEntity;

@Repository
public interface PapakiDomainRepository extends JpaRepository<PapakiDomainEntity, Long>  {

	List<PapakiDomainEntity> findByAdminUser(String adminUser);
	
	Optional<PapakiDomainEntity> findOneByDomainName(String domainName);
	
}
