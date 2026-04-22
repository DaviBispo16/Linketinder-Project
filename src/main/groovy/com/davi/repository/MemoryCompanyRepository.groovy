package com.davi.repository

class MemoryCompanyRepository implements ICompanyRepository {
    private List<Map> companies = []

    @Override
    void insertCompany(String id, String name, String cnpj, String email, String description, String password, String location_id) {
        companies << [id: id, name: name, cnpj: cnpj, email: email, description: description, password: password, location_id: location_id]
    }

    @Override
    List<Map> listCompany() {
        return companies
    }

    @Override
    Map findCompanyById(String id) {
        return null
    }

    @Override
    void updateCompany(String name, String cnpj, String email, String description, String password) {

    }

    @Override
    int deleteCompanyById(String id) {
        return 0
    }
}
