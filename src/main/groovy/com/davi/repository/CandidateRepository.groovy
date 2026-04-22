package com.davi.repository

import groovy.sql.Sql

class CandidateRepository implements ICandidateRepository {
    private final Sql sql

    CandidateRepository(Sql sql) {
        this.sql = sql
    }

    void insertCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password, String location_id) {
        sql.executeInsert(
                'INSERT INTO candidate (id, first_name, last_name, email, cpf, description, password, location_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)',
                [id, first_name, last_name, email, cpf, description, password, location_id]
        )
    }

    List<Map> listCandidate() {
        sql.rows('SELECT first_name, last_name, email, cpf, description FROM candidate ORDER BY id')
    }

    Map findCandidateById(Long id) {
        sql.firstRow(
                'SELECT first_name, last_name, email, cpf, description FROM candidate WHERE id = ?',
                [id]
        )
    }

    void updateCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password) {
        sql.executeUpdate(
                '''
                    UPDATE candidate
                    SET first_name = ?, last_name = ?, email = ?, cpf = ?, description = ?, password = ?
                    WHERE id = ?
                    ''',
                [first_name, last_name, email, cpf, description, password, id]
        )
    }

    int deleteCandidateById(Long id) {
        sql.executeUpdate(
                'DELETE FROM candidate WHERE id = ?',
                [id]
        )
    }
}
