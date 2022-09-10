-- Table: public.student

-- DROP TABLE IF EXISTS public.student;

CREATE TABLE IF NOT EXISTS public.student
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    age integer NOT NULL,
    firstname character varying(255) COLLATE pg_catalog."default",
    lastname character varying(255) COLLATE pg_catalog."default",
    "time" timestamp without time zone,
    groupid_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT student_pkey PRIMARY KEY (id),
    CONSTRAINT fkksusqgyphe7lgrtdka4mvdu3n FOREIGN KEY (groupid_id)
        REFERENCES public.studentgroup (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;
