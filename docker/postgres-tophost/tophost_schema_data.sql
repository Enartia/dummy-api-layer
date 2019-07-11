CREATE TABLE public.users_tophost (
	id bigserial NOT NULL,
	username varchar(50) NOT NULL,
	CONSTRAINT uk_bndlf2114knojoodjjxqipj8r UNIQUE (username),
	CONSTRAINT users_tophost_pkey PRIMARY KEY (id)
);

CREATE TABLE public.domains_tophost (
	id bigserial NOT NULL,
	domain varchar(50) NOT NULL,
	user_id int8 NULL,
	CONSTRAINT domains_tophost_pkey PRIMARY KEY (id),
	CONSTRAINT uk_feq02fo3brgobvx2ito09kspj UNIQUE (domain),
	CONSTRAINT fkooa2eixhnb52ve6j4g2aj7kop FOREIGN KEY (user_id) REFERENCES users_tophost(id)
);

INSERT INTO public.users_tophost (username) VALUES ('admin'),('user');