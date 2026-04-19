package service

import com.davi.model.Company
import com.davi.service.CompanyService
import com.davi.repository.MemoryCompanyRepository
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

class CompanyTest {

    MemoryCompanyRepository memoryRepo = new MemoryCompanyRepository()
    CompanyService companyService = new CompanyService(memoryRepo)

    @Test
    @DisplayName("When a company should be sucessfully created")
    void companyCreatedWithSuccessfully() {
        Company company = new Company("ZG Acelera", "12.345.678/0001-90", "contato@acelera.com.br", "Software house", "pass123", "loc-1")
        companyService.create(company)
        assertEquals(1, companyService.listAll().size())
    }

    @Test
    @DisplayName("When a company should be sucessfully listed")
    void companyListedWithSuccessfully() {
        Company firstCompany = new Company("FlowTech Solutions", "12345678000190", "contato@flowtech.example", "Software house", "pass123", "loc-1")
        Company secondCompany = new Company("Bahia Payments", "98765432000110", "suporte@baha", "Serviços", "pass123", "loc-2")
        Company thirdCompany = new Company("Rio Data Lab", "45678912000133", "hello@rio", "Consultoria", "pass123", "loc-3")

        companyService.create(firstCompany)
        companyService.create(secondCompany)
        companyService.create(thirdCompany)

        List<Map> companies = companyService.listAll()
        assertEquals(3, companyService.listAll().size())
    }
}
