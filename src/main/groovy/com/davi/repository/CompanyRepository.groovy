package com.davi.repository

import groovy.sql.Sql

class CompanyRepository implements ICompanyRepository {
    private final Sql sql

    CompanyRepository(Sql sql) {
        this.sql = sql
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
