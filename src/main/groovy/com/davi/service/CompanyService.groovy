package com.davi.service

import com.davi.model.Company

class CompanyService {
    private final List<Company> companies = []

    Company create(Company company) {
        companies << company
        return company;
    }

    List<Company> listAll() {
        return companies
    }

}
