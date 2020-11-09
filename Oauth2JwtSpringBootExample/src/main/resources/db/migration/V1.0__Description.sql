CREATE TABLE IF NOT EXISTS oauth_client_details (
    client_id VARCHAR(255) NOT NULL PRIMARY KEY,
    client_secret VARCHAR(255) NOT NULL,
    resource_ids VARCHAR(255) DEFAULT NULL,
    scope VARCHAR(255) DEFAULT NULL,
    authorized_grant_types VARCHAR(255) DEFAULT NULL,
    web_server_redirect_uri VARCHAR(255) DEFAULT NULL,
    authorities VARCHAR(255) DEFAULT NULL,
    access_token_validity INTEGER DEFAULT NULL,
    refresh_token_validity INTEGER DEFAULT NULL,
    additional_information VARCHAR(4096) DEFAULT NULL,
    autoapprove VARCHAR(255) DEFAULT NULL);


CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario serial,
    nombre_usuario VARCHAR(45),
    contrasena VARCHAR(100) ,
    PRIMARY KEY (id_usuario)
);

CREATE TABLE IF NOT EXISTS roles (
    id_rol SERIAL PRIMARY KEY, 
    nombre VARCHAR(60) UNIQUE);

CREATE TABLE IF NOT EXISTS usuario_rol (
    id_rol INTEGER,
    FOREIGN KEY(id_rol) REFERENCES roles(id_rol),
    id_usuario INTEGER, 
    FOREIGN KEY(id_usuario) REFERENCES usuarios(id_usuario));

INSERT INTO oauth_client_details (client_id, client_secret, resource_ids, scope, authorized_grant_types, 
    web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, 
    autoapprove) VALUES ('USER_CLIENT_APP', '$2a$10$vY9SkPQrAJbUvTL6/5fvce1SBBzlDYw0YPxabcmH86B0O9vzeqire',
	'oauth2-resource,husj_resource', 'role_admin,role_user', 'authorization_code,password,refresh_token,implicit,client_credentials',
	NULL, NULL, 900, 3600, '{}', NULL);

INSERT INTO usuarios(id_usuario,nombre_usuario,contrasena) VALUES (1,'admin','$2a$10$vY9SkPQrAJbUvTL6/5fvce1SBBzlDYw0YPxabcmH86B0O9vzeqire');
INSERT INTO roles(id_rol, nombre) VALUES (1,'Administrador');
INSERT INTO usuario_rol(id_rol,id_usuario) VALUES (1,1);

