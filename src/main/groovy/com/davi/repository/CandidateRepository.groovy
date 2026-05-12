package com.davi.repository

import groovy.sql.Sql

import com.davi.model.Candidate

class CandidateRepository implements ICandidateRepository {
    private final Sql sql

    CandidateRepository(Sql sql) {
        this.sql = sql
    }

    @Override
    Candidate insertCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password, String location_id) {
        sql.executeInsert(
                'INSERT INTO candidate (id, first_name, last_name, email, cpf, description, password, location_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)',
                [id, first_name, last_name, email, cpf, description, password, location_id]
        )
        return new Candidate(id: id, first_name: first_name, last_name: last_name, email: email, cpf: cpf, description: description, password: password, location_id: location_id)
    }

    @Override
    List<Candidate> listCandidate() {
        return sql.rows('SELECT id, first_name, last_name, email, cpf, description, password, location_id FROM candidate ORDER BY id').collect { row ->
            new Candidate(id: row.id, first_name: row.first_name, last_name: row.last_name, email: row.email, cpf: row.cpf, description: row.description, password: row.password, location_id: row.location_id)
        }
    }

    @Override
    Candidate findCandidateById(String id) {
        def row = sql.firstRow(
                'SELECT id, first_name, last_name, email, cpf, description, password, location_id FROM candidate WHERE id = ?',
                [id]
        )
        if (row) {
            return new Candidate(id: row.id, first_name: row.first_name, last_name: row.last_name, email: row.email, cpf: row.cpf, description: row.description, password: row.password, location_id: row.location_id)
        }
        return null
    }

    @Override
    Candidate updateCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password) {
        sql.executeUpdate(
                '''
                    UPDATE candidate
                    SET first_name = ?, last_name = ?, email = ?, cpf = ?, description = ?, password = ?
                    WHERE id = ?
                    ''',
                [first_name, last_name, email, cpf, description, password, id]
        )
        return findCandidateById(id)
    }

    @Override
    boolean deleteCandidateById(String id) {
        int rows = sql.executeUpdate(
                'DELETE FROM candidate WHERE id = ?',
                [id]
        )
        return rows > 0
    }
}
