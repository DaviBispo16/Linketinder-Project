create database linketinder

create table location (
  id varchar(255) primary key,
  postal_code char(20) not null,
  city varchar(100) not null,
  nation varchar(100) not null,
  country varchar(100) not null,
  created_at timestamp with time zone default CURRENT_TIMESTAMP,
  updated_at timestamp with time zone default CURRENT_TIMESTAMP
)

create table candidate(
  id varchar(255) primary key,
  first_name varchar(100) not null,
  last_name varchar(100) not null,
  email varchar(255) unique not null,
  cpf varchar(14) not null unique,
  description text,
  password varchar(255) not null,
  created_at timestamp with time zone default CURRENT_TIMESTAMP,
  updated_at timestamp with time zone default CURRENT_TIMESTAMP,
  location_id varchar(255) references location(id)
)

create table company(
  id varchar(255) primary key,
  name varchar(100) not null,
  cnpj varchar(14) not null unique,
  email varchar(255) unique not null,
  description text,
  password varchar(255) not null,
  created_at timestamp with time zone default CURRENT_TIMESTAMP,
  updated_at timestamp with time zone default CURRENT_TIMESTAMP,
  location_id varchar(255) references location(id)
)

create table job(
  id varchar(255) primary key,
  name varchar(255) primary key,
  description text,
  job_location varchar(100) not null,
  created_at timestamp with time zone default CURRENT_TIMESTAMP,
  updated_at timestamp with time zone default CURRENT_TIMESTAMP,
  company_id references company(id)
) 

create table skill(
  id varchar(255) primary key,
  name varchar(255) not null,
  created_at timestamp with time zone default CURRENT_TIMESTAMP,
  updated_at timestamp with time zone default CURRENT_TIMESTAMP
)

create table candidate_skill(
  candidate_id varchar(255) references candidate(id) on delete cascade,
  skill_id varchar(255) references skill(id) on delete cascade
)

create table job_skill(
    skill_id varchar(255) references skill(id) on delete cascade,
    job_id varchar(255) references job(id) on delete cascade
)

create table candidate_like(
  candidate_id varchar(255) references candidate(id),
  job_id varchar(255) references job(id),
  created_at timestamp with time zone default CURRENT_TIMESTAMP,
  updated_at timestamp with time zone default CURRENT_TIMESTAMP
)

create table company_like(
  company_id varchar(255) references company(id),
  candidate_id varchar(255) references candidate(id),
  created_at timestamp with time zone default CURRENT_TIMESTAMP,
  updated_at timestamp with time zone default CURRENT_TIMESTAMP
)

INSERT INTO location (id, postal_code, city, nation, country)
VALUES 
('loc-go','234323-123', 'Goiás', 'SP', 'Brazil'),
('loc-ba','234323-113', 'Bahia', 'RJ', 'Brazil'),
('loc-bh', '12323-123', 'Belo Horizonte', 'MG', 'Brazil'),
('loc-cur', '654323-123', 'Curitiba', 'PR', 'Brazil'),
('loc-fln', '74323-123', 'Florianópolis', 'SC', 'Brazil');


insert into candidate (id, first_name, last_name, email, cpf, description, password, location_id)
VALUES 
('cand-001', 'Alice', 'Silva', 'alice.silva@email.com', '123.456.789-10', 'Senior Fullstack Developer with 10 years of experience.', 'hashed_pass_1', 'loc-sp-01'),
('cand-002', 'Bruno', 'Santos', 'bruno.santos@email.com', '234.567.890-11', 'Junior Data Scientist passionate about Machine Learning.', 'hashed_pass_2', 'loc-rj-02'),
('cand-003', 'Carla', 'Oliveira', 'carla.olive@email.com', '345.678.901-12', 'UX/UI Designer focused on accessibility and mobile-first design.', 'hashed_pass_3', 'loc-mg-03'),
('cand-004', 'Diego', 'Souza', 'diego.souza@email.com', '456.789.012-13', 'Project Manager with PMP certification and agile expertise.', 'hashed_pass_4', 'loc-sc-04'),
('cand-005', 'Elena', 'Pereira', 'elena.p@email.com', '567.890.123-14', 'DevOps Engineer specialized in AWS and Kubernetes.', 'hashed_pass_5', 'loc-pr-05');


INSERT INTO company (id, name, cnpj, email, description, password, location_id)
VALUES 
('comp-1', 'TechNova', '12345678000101', 'hr@technova.com', 'Cloud Solutions', 'corp123', 'loc-go'),
('comp-2', 'GreenHorizon', '23456789000102', 'jobs@greenh.com', 'Renewable Energy', 'corp123', 'loc-cur'),
('comp-3', 'BlueBank', '34567890000103', 'recruitment@blue.com', 'Digital Banking', 'corp123', 'loc-ba'),
('comp-4', 'RetailFlow', '45678901000104', 'info@retailflow.com', 'E-commerce', 'corp123', 'loc-bh'),
('comp-5', 'CyberGuard', '56789012000105', 'security@cyber.com', 'Cybersecurity', 'corp123', 'loc-ba');