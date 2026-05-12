package com.davi.repository

import groovy.sql.Sql

import com.davi.model.Company

class CompanyRepository implements ICompanyRepository {
    private final Sql sql

    CompanyRepository(Sql sql) {
        this.sql = sql
    }

    @Override
    Company insertCompany(String id, String name, String cnpj, String email, String description, String password, String location_id) {
        sql.executeInsert(
                'INSERT INTO company (id, name, cnpj, email, description, password, location_id) VALUES (?, ?, ?, ?, ?, ?, ?)',
                [id, name, cnpj, email, description, password, location_id]
        )
        return new Company(id: id, name: name, cnpj: cnpj, email: email, description: description, password: password, location_id: location_id)
    }

    @Override
    List<Company> listCompany() {
        return sql.rows('SELECT id, name, cnpj, email, description, password, location_id FROM company ORDER BY id').collect { row ->
            new Company(id: row.id, name: row.name, cnpj: row.cnpj, email: row.email, description: row.description, password: row.password, location_id: row.location_id)
        }
    }

    @Override
    Company findCompanyById(String id) {
        def row = sql.firstRow(
                'SELECT id, name, cnpj, email, description, password, location_id FROM company WHERE id = ?',
                [id]
        )
        if (row) {
            return new Company(id: row.id, name: row.name, cnpj: row.cnpj, email: row.email, description: row.description, password: row.password, location_id: row.location_id)
        }
        return null
    }

    @Override
    Company updateCompany(String name, String cnpj, String email, String description, String password) {
        sql.executeUpdate(
                '''
                    UPDATE company
                    SET name = ?, email = ?, description = ?, password = ?
                    WHERE cnpj = ?
                    ''',
                [name, email, description, password, cnpj]
        )
        def row = sql.firstRow('SELECT id, name, cnpj, email, description, password, location_id FROM company WHERE cnpj = ?', [cnpj])
        if (row) {
            return new Company(id: row.id, name: row.name, cnpj: row.cnpj, email: row.email, description: row.description, password: row.password, location_id: row.location_id)
        }
        return null
    }

    @Override
    boolean deleteCompanyById(String id) {
        int rows = sql.executeUpdate(
                'DELETE FROM company WHERE id = ?',
                [id]
        )
        return rows > 0
    }
}
