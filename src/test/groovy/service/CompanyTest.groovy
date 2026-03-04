package service

import com.davi.model.Company
import com.davi.service.CompanyService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*


class CompanyTest {
    private CompanyService companyService = new CompanyService()

    @Test
    @DisplayName("When a company should be sucessfully created")
    void companyCreatedWithSuccessfully() {
        Company company = new Company('ZG Acelera',   'contato@acelera.com.br',   'GO', '01000-000', 'Software house focada em integração e automação.', '12.345.678/0001-90', 'Brazil')
        companyService.create(company)
        assertEquals(1, companyService.listAll().size())
    }

    @Test
    @DisplayName("When a company should be sucessfully listed")
    void companyListedWithSuccessfully() {
        Company firstCompany = new Company('FlowTech Solutions',   'contato@flowtech.example',   'SP', '01000-000', 'Software house focada em integração e automação.', '12.345.678/0001-90', 'Brazil')
        Company secondCompany = new Company('Bahia Payments',       'suporte@bahiapay.example',   'BA', '40000-000', 'Serviços de pagamento e adquirência para varejo.',  '98.765.432/0001-10', 'Brazil')
        Company thirdCompany = new Company('Rio Data Lab',         'hello@riodatalab.example',   'RJ', '20000-000', 'Consultoria em dados, BI e observabilidade.', '45.678.912/0001-33', 'Brazil')

        companyService.create(firstCompany)
        companyService.create(secondCompany)
        companyService.create(thirdCompany)

        List<Company> companies = companyService.listAll();
        assertEquals(3, companyService.listAll().size())
    }
}
