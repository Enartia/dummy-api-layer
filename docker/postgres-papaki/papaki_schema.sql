CREATE TABLE public.domains_papaki (
	id bigserial NOT NULL,
	administrator varchar(50) NOT NULL,
	domain_name varchar(50) NOT NULL,
	CONSTRAINT domains_papaki_pkey PRIMARY KEY (id),
	CONSTRAINT uk_8xk278e9bacbk607kghhgtcl3 UNIQUE (domain_name)
);