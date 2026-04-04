package com.davi

import com.davi.database.DbConfig
import com.davi.model.Candidate
import com.davi.model.Company
import com.davi.repository.CandidateRepository
import com.davi.repository.CompanyRepository
import com.davi.service.CandidateService
import com.davi.service.CompanyService
import groovy.sql.Sql

static void main(String[] args) {
    CompanyService companyService = new CompanyService()
    CandidateService candidateService = new CandidateService()

    List<Candidate> candidates = [
            candidateService.create(new Candidate('Lucas', 'Mateus', 'lucas.mateus@example.com1', '123.456.789-01', 'QA / test automation', '123456', 'loc-go')),
            candidateService.create(new Candidate('Mariana', 'Silva', 'mariana.silva@example.com1', '987.654.321-01', 'Backend developer (APIs)', '123456', 'loc-go')),
            candidateService.create(new Candidate('Rafael', 'Souza', 'rafael.souza@example.com1', '741.852.963-11', 'Software engineer (architecture)', '123456', 'loc-go')),
            candidateService.create(new Candidate('Camila', 'Oliveira', 'camila.oliveira@example.com1', '159.357.258-21', 'Product designer (UX/UI)', '123456', 'loc-go')),
            candidateService.create(new Candidate('Bruno', 'Almeida', 'bruno.almeida@example.com1', '456.789.123-31', 'DevOps (pipelines/containers)', '123456', 'loc-go')),
    ]

    List<Company> companies = [
            companyService.create(new Company('FlowTech Solutions', '12345678000190', 'contato@flowtech.example', 'Software house focada em integração e automação.', '123456', 'loc-go')),
            companyService.create(new Company('Bahia Payments', '98765432000110', 'suporte@bahiapay.example', 'Serviços de pagamento e adquirência para varejo.', '123456', 'loc-go')),
            companyService.create(new Company('Rio Data Lab', '45678912000133', 'hello@riodatalab.example', 'Consultoria em dados, BI e observabilidade.', '123456', 'loc-go')),
            companyService.create(new Company('Minas Cloud Ops', '56789123000144', 'ops@minascloud.example', 'DevOps e cloud para empresas de médio porte.', '123456', 'loc-go')),
            companyService.create(new Company('Sul Commerce Group', '67891234000155', 'vendas@sulcommerce.example', 'Plataforma de e-commerce e logística integrada.', '123456', 'loc-go'))
    ]

    Sql.withInstance(
            DbConfig.URL,
            DbConfig.USER,
            DbConfig.PASSWORD,
            DbConfig.DRIVER
    ) { sql ->
        def candidateRepo = new CandidateRepository((Sql) sql)
        candidateRepo.createTable()
        candidates.each { candidate ->
            try {
                candidateRepo.insertCandidate(
                        candidate.id, candidate.first_name, candidate.last_name, candidate.email, candidate.cpf, candidate.description, candidate.password, candidate.location_id
                )
                println "Candidato ${candidate.first_name} ${candidate.last_name} adicionado ao banco de dados com sucesso."
            } catch (Exception e) {
                println "Candidato ${candidate.first_name} já existe ou erro ocorreu: ${e.message}"
            }
        }

        def companyRepo = new CompanyRepository((Sql) sql)
        companyRepo.createTable()
        companies.each { company ->
            try {
                companyRepo.insertCompany(
                        company.id, company.name, company.cnpj, company.email, company.description, company.password, company.location_id
                )
                println "Empresa ${company.name} adicionada ao banco de dados com sucesso."
            } catch (Exception e) {
                println "Empresa ${company.name} já existe ou erro ocorreu: ${e.message}"
            }
        }
    }

    Scanner scanner = new Scanner(System.in)
    boolean running = true
    while (running) {
        println "1) Listar Empresas"
        println "2) Listar Candidatos"
        println "3) Cadastro de Empresa"
        println "4) Cadastro de Candidato"
        print "Escolha uma opção: "

        int option = -1
        if (scanner.hasNextInt()) {
            option = scanner.nextInt()
            scanner.nextLine()
        } else {
            scanner.nextLine()
        }

        switch (option) {
            case 1:
                groovy.sql.Sql.withInstance(
                        com.davi.database.DbConfig.URL,
                        com.davi.database.DbConfig.USER,
                        com.davi.database.DbConfig.PASSWORD,
                        com.davi.database.DbConfig.DRIVER
                ) { sql ->
                    def repo = new CompanyRepository(sql as groovy.sql.Sql)
                    repo.listCompany().each { row ->
                        println """
                        Nome: ${row.name}
                        CNPJ: ${row.cnpj}
                        Email: ${row.email}
                        Description: ${row.description}
                        """
                    }
                }
                break

            case 2:
                groovy.sql.Sql.withInstance(
                        com.davi.database.DbConfig.URL,
                        com.davi.database.DbConfig.USER,
                        com.davi.database.DbConfig.PASSWORD,
                        com.davi.database.DbConfig.DRIVER
                ) { sql ->
                    def repo = new CandidateRepository(sql as groovy.sql.Sql)
                    repo.listCandidate().each { row ->
                        println """
                        Nome: ${row.first_name} ${row.last_name}
                        Email: ${row.email}
                        CPF: ${row.cpf}
                        Description: ${row.description}
                        """
                    }
                }
                break

            case 3:
                println("Nome:")
                String name = scanner.nextLine()

                println("CNPJ:")
                String cnpj = scanner.nextLine()

                println("E-mail:")
                String email = scanner.nextLine()

                println("Descrição:")
                String description = scanner.nextLine()

                println("Senha:")
                String password = scanner.nextLine()

                println("Location ID:")
                String locationId = scanner.nextLine()

                Company company = new Company(name, cnpj, email, description, password, locationId)
                companyService.create(company)
                try {
                    groovy.sql.Sql.withInstance(
                            com.davi.database.DbConfig.URL,
                            com.davi.database.DbConfig.USER,
                            com.davi.database.DbConfig.PASSWORD,
                            com.davi.database.DbConfig.DRIVER
                    ) { sql ->
                        def repo = new CompanyRepository(sql as groovy.sql.Sql)
                        repo.insertCompany(company.id, company.name, company.cnpj, company.email, company.description, company.password, company.location_id)
                    }
                    println "Empresa ${company.name} cadastrada com sucesso!"
                } catch (Exception e) {
                    println "Erro ao salvar empresa no banco: ${e.message}"
                }
                break

            case 4:
                println("Primeiro Nome:")
                String firstName = scanner.nextLine()

                println("Sobrenome:")
                String lastName = scanner.nextLine()

                println("E-mail:")
                String email = scanner.nextLine()

                println("CPF:")
                String cpf = scanner.nextLine()

                println("Descrição:")
                String description = scanner.nextLine()

                println("Senha:")
                String password = scanner.nextLine()

                println("Location ID:")
                String locationId = scanner.nextLine()

                Candidate candidate = new Candidate(firstName, lastName, email, cpf, description, password, locationId)
                candidateService.create(candidate)
                try {
                    groovy.sql.Sql.withInstance(
                            com.davi.database.DbConfig.URL,
                            com.davi.database.DbConfig.USER,
                            com.davi.database.DbConfig.PASSWORD,
                            com.davi.database.DbConfig.DRIVER
                    ) { sql ->
                        def repo = new CandidateRepository(sql as groovy.sql.Sql)
                        repo.insertCandidate(candidate.id, candidate.first_name, candidate.last_name, candidate.email, candidate.cpf, candidate.description, candidate.password, candidate.location_id)
                    }
                    println "Candidato ${candidate.first_name} ${candidate.last_name} cadastrado com sucesso!"
                } catch (Exception e) {
                    println "Erro ao salvar candidato no banco: ${e.message}"
                }
                break

            default:
                println "Opção inválida, tente novamente"
        }
    }

}