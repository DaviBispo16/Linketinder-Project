package com.davi.repository

import groovy.sql.Sql

class CompanyRepository {
    private final Sql sql

    CompanyRepository(Sql sql) {
        this.sql = sql
    }

    void createTable() {
        sql.execute("""
            CREATE TABLE IF NOT EXISTS company (
            id varchar(255) primary key,
            name varchar(100) not null,
            cnpj varchar(18) not null unique,
            email varchar(255) unique not null,
            description text,
            password varchar(255) not null,
            created_at timestamp with time zone default CURRENT_TIMESTAMP,
            updated_at timestamp with time zone default CURRENT_TIMESTAMP,
            location_id varchar(255) references location(id)
            )
        """)
    }

    void insertCompany(String id, String name, String cnpj, String email, String description, String password, String location_id) {
        sql.executeInsert(
                'INSERT INTO company (id, name, cnpj, email, description, password, location_id) VALUES (?, ?, ?, ?, ?, ?, ?)',
                [id, name, cnpj, email, description, password, location_id]
        )
    }

    List<Map> listCompany() {
        sql.rows('SELECT name, cnpj, email, description, password FROM company ORDER BY id')
    }

    Map findCompanyById(String id) {
        sql.firstRow(
                'SELECT name, cnpj, email, description, password FROM company WHERE id = ?',
                [id]
        )
    }

    void updateCompany(String name, String cnpj, String email, String description, String password) {
        sql.executeUpdate(
                '''
                    UPDATE company
                    SET first_name = ?, last_name = ?, email = ?, cpf = ?, description = ?, password = ?
                    WHERE id = ?
                    ''',
                [first_name, last_name, email, cpf, description, password, id]
        )
    }

    int deleteCompanyById(String id) {
        sql.executeUpdate(
                'DELETE FROM company WHERE id = ?',
                [id]
        )
    }

}
