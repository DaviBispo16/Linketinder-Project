package com.davi.service

import com.davi.model.Candidate

class CandidateService {
    private List<Candidate> candidates = []

    Candidate create(Candidate newCandidate) {
        candidates << newCandidate
        return newCandidate
    }

    List<Candidate> listAll() {
        return candidates
    }
}
