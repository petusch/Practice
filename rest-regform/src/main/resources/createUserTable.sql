-- DROP TABLE public.users;

CREATE TABLE public.users
(
    id SERIAL NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    surname character varying COLLATE pg_catalog."default" NOT NULL,
    birthdate timestamp without time zone NOT NULL,
    creationdate timestamp without time zone NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;