package com.davi.repository

import com.davi.model.Candidate

interface ICandidateRepository {
    Candidate insertCandidate(String id, String first_name, String last_name, String email,
                         String cpf, String description, String password, String location_id)
    List<Candidate> listCandidate()
    Candidate findCandidateById(String id)
    Candidate updateCandidate(String id, String first_name, String last_name, String email,
                         String cpf, String description, String password)

    boolean deleteCandidateById(String id)
}
