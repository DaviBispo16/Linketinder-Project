package repository

import com.davi.repository.CompanyRepository
import groovy.sql.Sql
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import static org.junit.jupiter.api.Assertions.*
import static org.mockito.Mockito.*

class CompanyRepositoryTest {

    private Sql mockSql
    private CompanyRepository repository

    @BeforeEach
    void setUp() {
        mockSql = mock(Sql.class)
        repository = new CompanyRepository(mockSql)
    }

    @Test
    @DisplayName("Should successfully insert a company using Mockito")
    void testInsertCompanyWithMockedDb() {
        // Arrange
        String id = "123e4567"
        String name = "ZG Acelera"
        String cnpj = "12.345.678/0001-90"
        String email = "contato@acelera.com.br"
        String description = "Software house"
        String password = "password"
        String locationId = "loc-1"

        repository.insertCompany(id, name, cnpj, email, description, password, locationId)

        verify(mockSql, times(1)).executeInsert(
            'INSERT INTO company (id, name, cnpj, email, description, password, location_id) VALUES (?, ?, ?, ?, ?, ?, ?)',
            [id, name, cnpj, email, description, password, locationId]
        )
    }

    @Test
    @DisplayName("Should list companies successfully using Mockito")
    void testListCompaniesWithMockedDb() {
        List<Map> mockResult = [
            [name: "ZG Acelera", cnpj: "12.345.678/0001-90", email: "contato@acelera.com.br", description: "Software house", password: "password"]
        ]
        when(mockSql.rows('SELECT name, cnpj, email, description, password FROM company ORDER BY id')).thenReturn(mockResult)

        List<Map> result = repository.listCompany()

        assertEquals(1, result.size())
        assertEquals("ZG Acelera", result[0].name)
        verify(mockSql, times(1)).rows('SELECT name, cnpj, email, description, password FROM company ORDER BY id')
    }
}
