CREATE TABLE IF NOT EXISTS public.studentgroup
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT studentgroup_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;
