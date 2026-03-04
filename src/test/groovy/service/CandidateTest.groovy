package service

import com.davi.model.Candidate
import com.davi.service.CandidateService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

class CandidateTest {

    CandidateService candidateService = new CandidateService()

    @Test
    @DisplayName("When a candidate should be sucessfully created")
    void candidateCreatedWithSuccessfully() {
        Candidate candidate= new Candidate("Jonh Doe", "jonhdoe@gmail.com", "Santa Catarina", "12321312", "Apaixonado por tecnologia", "12312311242", 21)
        candidateService.create(candidate)
        assertEquals(1, candidateService.listAll().size())
    }

    @Test
    @DisplayName("When a candidate should be sucessfully listed")
    void candidateListedWithSuccessfully() {
        Candidate firstCandidate = new Candidate("Max", "max@gmail.com", "Rio de Janeiro", "123211232", "Amo estudar", "2312232312", 23)
        Candidate secondCandidate = new Candidate("Jonh", "jonh12@gmail.com", "São Paulo", "126756232", "Adoro física", "45445454534", 19)

        candidateService.create(firstCandidate)
        candidateService.create(secondCandidate)

        assertEquals(2, candidateService.listAll().size())
    }


}
