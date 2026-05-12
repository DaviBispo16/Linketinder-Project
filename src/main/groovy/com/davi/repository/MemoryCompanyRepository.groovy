package com.davi.repository

import com.davi.model.Company

class MemoryCompanyRepository implements ICompanyRepository {
    private List<Company> companies = []

    @Override
    Company insertCompany(String id, String name, String cnpj, String email, String description, String password, String location_id) {
        def company = new Company(id: id, name: name, cnpj: cnpj, email: email, description: description, password: password, location_id: location_id)
        companies << company
        return company
    }

    @Override
    List<Company> listCompany() {
        return companies
    }

    @Override
    Company findCompanyById(String id) {
        return companies.find { it.id == id }
    }

    @Override
    Company updateCompany(String name, String cnpj, String email, String description, String password) {
        def company = companies.find { it.cnpj == cnpj }
        if (company) {
            company.name = name
            company.email = email
            company.description = description
            company.password = password
        }
        return company
    }

    @Override
    boolean deleteCompanyById(String id) {
        int initialSize = companies.size()
        companies.removeAll { it.id == id }
        return companies.size() < initialSize
    }
}
