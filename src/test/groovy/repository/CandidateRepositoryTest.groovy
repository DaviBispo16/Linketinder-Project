package repository

import com.davi.repository.CandidateRepository
import groovy.sql.Sql
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import static org.junit.jupiter.api.Assertions.*
import static org.mockito.Mockito.*

class CandidateRepositoryTest {

    private Sql mockSql
    private CandidateRepository repository

    @BeforeEach
    void setUp() {
        mockSql = mock(Sql.class)
        repository = new CandidateRepository(mockSql)
    }

    @Test
    @DisplayName("Should successfully insert a candidate using Mockito")
    void testInsertCandidateWithMockedDb() {
        String id = "123e4567"
        String firstName = "Davi"
        String lastName = "Silva"
        String email = "davi@example.com"
        String cpf = "12312312312"
        String description = "Developer"
        String password = "password"
        String locationId = "loc-1"

        repository.insertCandidate(id, firstName, lastName, email, cpf, description, password, locationId)

        verify(mockSql, times(1)).executeInsert(
            'INSERT INTO candidate (id, first_name, last_name, email, cpf, description, password, location_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)',
            [id, firstName, lastName, email, cpf, description, password, locationId]
        )
    }

    @Test
    @DisplayName("Should list candidates successfully using Mockito")
    void testListCandidatesWithMockedDb() {
        List<Map> mockResult = [
            [id: "1", first_name: "Davi", last_name: "Silva", email: "davi@example.com", cpf: "12312312312", description: "Developer", password: "pwd", location_id: "loc1"]
        ]
        when(mockSql.rows('SELECT id, first_name, last_name, email, cpf, description, password, location_id FROM candidate ORDER BY id')).thenReturn(mockResult)

        List<com.davi.model.Candidate> result = repository.listCandidate()

        assertEquals(1, result.size())
        assertEquals("Davi", result[0].first_name)
        verify(mockSql, times(1)).rows('SELECT id, first_name, last_name, email, cpf, description, password, location_id FROM candidate ORDER BY id')
    }
}
