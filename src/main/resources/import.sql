INSERT INTO permissions (id, permission_name) VALUES
  ('550e8400-e29b-41d4-a716-446655440001', 'READ'),
  ('550e8400-e29b-41d4-a716-446655440002', 'CREATE'),
  ('550e8400-e29b-41d4-a716-446655440003', 'UPDATE');

INSERT INTO roles (id, role_name) VALUES
  ('650e8400-e29b-41d4-a716-446655440004', 'ADMIN'),
  ('650e8400-e29b-41d4-a716-446655440005', 'MANAGER'),
  ('650e8400-e29b-41d4-a716-446655440006', 'EMPLOYEE');

INSERT INTO role_permissions (role_id, permission_id) VALUES
  ('650e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440001'), -- ADMIN -> READ
  ('650e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440002'), -- ADMIN -> CREATE
  ('650e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440003'), -- ADMIN -> UPDATE
  ('650e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440001'), -- MANAGER -> READ
  ('650e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440002'), -- MANAGER -> CREATE
  ('650e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440003'), -- MANAGER -> UPDATE
  ('650e8400-e29b-41d4-a716-446655440006', '550e8400-e29b-41d4-a716-446655440002'), -- EMPLOYEE -> CREATE
  ('650e8400-e29b-41d4-a716-446655440006', '550e8400-e29b-41d4-a716-446655440001'); -- EMPLOYEE -> READ

INSERT INTO employee (id, name, last_name, dni, phone, address, password, email, is_enable, account_no_expired, account_no_locked, credentials_no_expired) VALUES
  ('750e8400-e29b-41d4-a716-446655440006', 'Gerente', "Rodriguez", "41644197", 155651234, "Calle locura 123", '$2a$10$FEZurEdJ9R8VmdPR7qyFvebJaVlNByHEdxWXxlw6SWBCDUTZn5gb2', 'admin@example.com', true, true, true, true), -- password: admin
  ('750e8400-e29b-41d4-a716-446655440007', 'Empleado', "Ramirez", "41644198", 155443366, "Calle rabia 321", '$2a$10$uqE9z6UPiebEKuWOtJDss.Lacy2DFC3b7kmtrsCjjYnYGV4WNil7.', 'user@example.com', true, true, true, true); -- password: user

INSERT INTO user_roles (user_id, role_id) VALUES
  ('750e8400-e29b-41d4-a716-446655440006', '650e8400-e29b-41d4-a716-446655440005'),
  ('750e8400-e29b-41d4-a716-446655440007', '650e8400-e29b-41d4-a716-446655440006');