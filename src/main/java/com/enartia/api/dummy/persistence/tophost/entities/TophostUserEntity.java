package com.enartia.api.dummy.persistence.tophost.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users_tophost")
@Data
public class TophostUserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username", length = 50,  nullable = false, unique = true)
	private String username;
	
    @OneToMany(mappedBy = "adminUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TophostDomainEntity> domains = new ArrayList<>();
    
}
