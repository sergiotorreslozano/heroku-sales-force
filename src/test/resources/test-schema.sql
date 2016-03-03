CREATE TABLE ticks
(
  id bigint NOT NULL,
  time_stamp timestamp without time zone NOT NULL,
  CONSTRAINT ticks_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE ticks
  OWNER TO postgres;
  
  
CREATE TABLE users
(
  id bigint NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;



CREATE TABLE salesforcedev.account
(
  id bigint NOT NULL,
  _hc_err character varying(255),
  _hc_lastop character varying(255),
  createddate timestamp without time zone NOT NULL,
  lastmodifieddate timestamp without time zone,
  name character varying(255) NOT NULL,
  CONSTRAINT account_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE salesforcedev.account
  OWNER TO postgres;

  
  CREATE TABLE salesforcedev.profile
(
  id bigint NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT profile_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE salesforcedev.profile
  OWNER TO postgres;

  
CREATE TABLE salesforcedev."user"
(
  id bigint NOT NULL,
  last_change timestamp without time zone NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE salesforcedev."user"
  OWNER TO postgres;
