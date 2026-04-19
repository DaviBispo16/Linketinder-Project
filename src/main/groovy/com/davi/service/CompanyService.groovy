package com.davi.service

import com.davi.model.Company
import com.davi.repository.ICompanyRepository

class CompanyService {
    private final ICompanyRepository repository

    CompanyService(ICompanyRepository repository) {
        this.repository = repository
    }

    Company create(Company company) {
        repository.insertCompany(company.id, company.name, company.cnpj, company.email, company.description, company.password, company.location_id)
        return company
    }

    List<Map> listAll() {
        return repository.listCompany()
    }
}
