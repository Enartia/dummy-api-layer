package com.enartia.api.dummy.persistence.papaki.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="domains_papaki")
@Data
public class PapakiDomainEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="domain_name", length = 50,  nullable = false, unique = true)
	private String domainName;
	
	@Column(name="administrator", length = 50, nullable = false)
	private String adminUser;
	
}