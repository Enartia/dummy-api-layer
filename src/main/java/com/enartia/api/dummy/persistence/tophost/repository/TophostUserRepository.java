package com.enartia.api.dummy.persistence.tophost.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enartia.api.dummy.persistence.tophost.entities.TophostUserEntity;

@Repository
public interface TophostUserRepository extends JpaRepository<TophostUserEntity, Long> {

	Optional<TophostUserEntity> findOneByUsername(String username);
	
}
