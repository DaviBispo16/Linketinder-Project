package model

import com.davi.model.Company
import com.davi.service.CompanyService
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*


class CompanyTest {
    private CompanyService companyService;

    @Test
    void companyCreatedWithSucess() {
        Company company = new Company('ZG Acelera',   'contato@acelera.com.br',   'GO', '01000-000', 'Software house focada em integração e automação.', '12.345.678/0001-90', 'Brazil')

        List<Company> companies = companyService.create(company)

        assertEquals(1, companies.size())
    }
}
