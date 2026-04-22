package com.davi.repository

interface ICompanyRepository {
    void insertCompany(String id, String name, String cnpj, String email, String description, String password,
                       String location_id)
    List<Map> listCompany()
    Map findCompanyById(String id)
    void updateCompany(String name, String cnpj, String email, String description, String password)
    int deleteCompanyById(String id)
}
