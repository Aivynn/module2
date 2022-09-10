-- Table: public.subject

-- DROP TABLE IF EXISTS public.subject;

CREATE TABLE IF NOT EXISTS public.subject
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT subject_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;
