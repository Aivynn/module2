-- Table: public.teacher

-- DROP TABLE IF EXISTS public.teacher;

CREATE TABLE IF NOT EXISTS public.teacher
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    age integer NOT NULL,
    firstname character varying(255) COLLATE pg_catalog."default",
    lastname character varying(255) COLLATE pg_catalog."default",
    subject_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT teacher_pkey PRIMARY KEY (id),
    CONSTRAINT fk6e33amanj82xu1aebk6jwb1sg FOREIGN KEY (subject_id)
        REFERENCES public.subject (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;
