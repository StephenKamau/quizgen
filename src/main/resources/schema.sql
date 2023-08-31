CREATE TABLE IF NOT EXISTS quiz
(
    created_at timestamp
(
    6
) with time zone NOT NULL,
      id BIGSERIAL,
    updated_at timestamp
(
    6
)
  with time zone,
      created_by character varying (255),
    modified_by character varying
(
    255
) ,
    quiz_answer character varying
(
    255
) NOT NULL,
    quiz_description character varying
(
    255
) NOT NULL,
    quiz_options character varying
(
    255
) NOT NULL,
    quiz_title character varying
(
    255
) NOT NULL,
    CONSTRAINT quiz_pkey PRIMARY KEY
(
    id
)
    );