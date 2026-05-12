package com.davi.service

import com.davi.model.Candidate
import com.davi.repository.ICandidateRepository

class CandidateService {
    private final ICandidateRepository repository

    CandidateService(ICandidateRepository repository) {
        this.repository = repository
    }

    Candidate create(Candidate newCandidate) {
        return repository.insertCandidate(newCandidate.id, newCandidate.first_name, newCandidate.last_name, newCandidate.email, newCandidate.cpf, newCandidate.description, newCandidate.password, newCandidate.location_id)
    }

    List<Candidate> listAll() {
        return repository.listCandidate()
    }
}
