INSERT INTO role (role_id,role_name) VALUES (  1 ,'ROLE_ADMIN')ON CONFLICT (role_id) DO NOTHING;
INSERT INTO role (role_id,role_name) VALUES (  2 ,'ROLE_USER')ON CONFLICT (role_id) DO NOTHING;
INSERT INTO role (role_id,role_name) VALUES (  3 ,'ROLE_DRIVER')ON CONFLICT (role_id) DO NOTHING;
INSERT INTO role (role_id,role_name) VALUES ('4' ,'ROLE_STUFF')ON CONFLICT (role_id) DO NOTHING;
