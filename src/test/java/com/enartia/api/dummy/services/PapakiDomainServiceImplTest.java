package com.enartia.api.dummy.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.enartia.api.dummy.persistence.papaki.entities.PapakiDomainEntity;
import com.enartia.api.dummy.persistence.papaki.repository.PapakiDomainRepository;

@RunWith(SpringRunner.class)
public class PapakiDomainServiceImplTest {

	private static final String DOMAIN_IS_FREE = "domain.is.free";
	private static final String DOMAIN_IS_NOT_FREE = "domain.is.not.free";
	
	@TestConfiguration
    static class PapakiDomainServiceImplTestContextConfiguration {
  
        @Bean
        public DomainService domainService() {
            return new PapakiDomainServiceImpl();
        }
    }
	
	@Autowired
	private DomainService domainService;
	
	@MockBean
	private PapakiDomainRepository repository;
	
	@Test
	public void existsByDomainName_whenDomainIsFree_returnFalse() {
		when(repository.findOneByDomainName(DOMAIN_IS_FREE)).thenReturn(Optional.ofNullable(null));
		
		assertThat(domainService.existsByDomainName(DOMAIN_IS_FREE)).isFalse();
	}
	
	@Test
	public void existsByDomainName_whenDomainIsNotFree_returnTrue() {
		PapakiDomainEntity papakiDomainEntity = new PapakiDomainEntity();
		papakiDomainEntity.setAdminUser("testuser");
		papakiDomainEntity.setDomainName(DOMAIN_IS_NOT_FREE);
		
		when(repository.findOneByDomainName(DOMAIN_IS_NOT_FREE)).thenReturn(Optional.of(papakiDomainEntity));
		
		assertThat(domainService.existsByDomainName(DOMAIN_IS_NOT_FREE)).isTrue();
	}

}
