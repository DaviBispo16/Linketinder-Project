package com.davi.repository

import com.davi.model.Company

interface ICompanyRepository {
    Company insertCompany(String id, String name, String cnpj, String email, String description, String password,
                       String location_id)
    List<Company> listCompany()
    Company findCompanyById(String id)
    Company updateCompany(String name, String cnpj, String email, String description, String password)
    boolean deleteCompanyById(String id)
}
