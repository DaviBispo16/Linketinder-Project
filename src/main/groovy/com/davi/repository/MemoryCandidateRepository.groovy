package com.davi.repository

class MemoryCandidateRepository implements ICandidateRepository {
    private List<Map> candidates = []

    @Override
    void insertCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password, String location_id) {
        candidates << [id: id, first_name: first_name, last_name: last_name, email: email, cpf: cpf, description: description, password: password, location_id: location_id]
    }

    @Override
    List<Map> listCandidate() {
        return candidates
    }

    @Override
    Map findCandidateById(Long id) {
        return null
    }

    @Override
    void updateCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password) {

    }

    @Override
    int deleteCandidateById(Long id) {
        return 0
    }
}
