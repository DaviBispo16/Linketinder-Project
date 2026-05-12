package com.davi.repository

import com.davi.model.Candidate

class MemoryCandidateRepository implements ICandidateRepository {
    private List<Candidate> candidates = []

    @Override
    Candidate insertCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password, String location_id) {
        def candidate = new Candidate(id: id, first_name: first_name, last_name: last_name, email: email, cpf: cpf, description: description, password: password, location_id: location_id)
        candidates << candidate
        return candidate
    }

    @Override
    List<Candidate> listCandidate() {
        return candidates
    }

    @Override
    Candidate findCandidateById(String id) {
        return candidates.find { it.id == id }
    }

    @Override
    Candidate updateCandidate(String id, String first_name, String last_name, String email, String cpf, String description, String password) {
        def candidate = candidates.find { it.id == id }
        if (candidate) {
            candidate.first_name = first_name
            candidate.last_name = last_name
            candidate.email = email
            candidate.cpf = cpf
            candidate.description = description
            candidate.password = password
        }
        return candidate
    }

    @Override
    boolean deleteCandidateById(String id) {
        int initialSize = candidates.size()
        candidates.removeAll { it.id == id }
        return candidates.size() < initialSize
    }
}
