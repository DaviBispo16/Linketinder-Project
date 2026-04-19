package com.davi.repository

interface ICandidateRepository {
    void insertCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password, String location_id)
    List<Map> listCandidate()
}
