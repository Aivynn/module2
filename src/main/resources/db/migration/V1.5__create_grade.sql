
CREATE TABLE IF NOT EXISTS public.grade
(
    id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    value integer NOT NULL,
    student_id character varying(255) COLLATE pg_catalog."default",
    subjectname_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT grade_pkey PRIMARY KEY (id),
    CONSTRAINT fk2jlxowau51dupppt1kfs5hhg9 FOREIGN KEY (subjectname_id)
        REFERENCES public.subject (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fknrmfyw3u4l459wuii4g9nrb1b FOREIGN KEY (student_id)
        REFERENCES public.student (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;
