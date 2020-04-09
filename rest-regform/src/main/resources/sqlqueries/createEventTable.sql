-- DROP TABLE public.events;

CREATE TABLE public.events
(
    id SERIAL NOT NULL ,
    age_affilation boolean NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    event_date timestamp without time zone NOT NULL,
    description character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT events_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.events
    OWNER to postgres;