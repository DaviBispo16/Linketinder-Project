package service

import com.davi.model.Candidate
import com.davi.service.CandidateService
import com.davi.repository.MemoryCandidateRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

class CandidateTest {

    MemoryCandidateRepository memoryRepo = new MemoryCandidateRepository()
    CandidateService candidateService = new CandidateService(memoryRepo)

    @Test
    @DisplayName("When a candidate should be sucessfully created")
    void candidateCreatedWithSuccessfully() {
        Candidate candidate = new Candidate("Jonh", "Doe", "jonhdoe@gmail.com", "12312311242", "Apaixonado por tecnologia", "pass123", "loc-1")
        candidateService.create(candidate)
        assertEquals(1, candidateService.listAll().size())
    }

    @Test
    @DisplayName("When a candidate should be sucessfully listed")
    void candidateListedWithSuccessfully() {
        Candidate firstCandidate = new Candidate("Max", "Verstappen", "max@gmail.com", "2312232312", "Amo estudar", "pass123", "loc-1")
        Candidate secondCandidate = new Candidate("Jonh", "Doe", "jonh12@gmail.com", "45445454534", "Adoro física", "pass123", "loc-2")

        candidateService.create(firstCandidate)
        candidateService.create(secondCandidate)

        assertEquals(2, candidateService.listAll().size())
    }

}
