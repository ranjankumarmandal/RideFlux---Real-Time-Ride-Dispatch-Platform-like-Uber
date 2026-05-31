CREATE TABLE roles
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE users
(
    id UUID PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,

    first_name VARCHAR(100),
    last_name VARCHAR(100),

    enabled BOOLEAN DEFAULT TRUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_roles
(
    user_id UUID NOT NULL,
    role_id BIGINT NOT NULL,

    PRIMARY KEY(user_id, role_id),

    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
        REFERENCES users(id),

    CONSTRAINT fk_role
        FOREIGN KEY(role_id)
        REFERENCES roles(id)
);

CREATE TABLE refresh_tokens
(
    id UUID PRIMARY KEY,

    user_id UUID NOT NULL,

    token VARCHAR(1000) NOT NULL,

    expiry_date TIMESTAMP NOT NULL,

    CONSTRAINT fk_refresh_user
        FOREIGN KEY(user_id)
        REFERENCES users(id)
);