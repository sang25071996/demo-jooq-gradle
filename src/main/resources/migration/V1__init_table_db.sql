CREATE TABLE IF NOT EXISTS public.users
(
    id          SERIAL PRIMARY KEY,
    email       VARCHAR(50) UNIQUE,
    first_name    VARCHAR(255),
    last_name    VARCHAR(255),
    picture     TEXT,
    code         VARCHAR(255),
    created_date TIMESTAMPTZ,
    modified_date TIMESTAMPTZ,
    expired_date TIMESTAMPTZ,
    is_active    BOOLEAN
);

CREATE TABLE IF NOT EXISTS identity_provider
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
