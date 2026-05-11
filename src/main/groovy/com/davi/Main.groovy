package com.davi

import com.davi.database.ConnectionFactory
import com.davi.database.DatabaseConnectionFactory
import com.davi.model.Candidate
import com.davi.model.Company
import com.davi.repository.CandidateRepository
import com.davi.repository.CompanyRepository
import com.davi.service.CandidateService
import com.davi.service.CompanyService
import groovy.sql.Sql

static void main(String[] args) {
    ConnectionFactory factory = DatabaseConnectionFactory.getFactory("postgres")
    Sql globalSql = factory.createConnection()

    def companyRepo = new CompanyRepository(globalSql)
    def candidateRepo = new CandidateRepository(globalSql)

    CompanyService companyService = new CompanyService(companyRepo)
    CandidateService candidateService = new CandidateService(candidateRepo)

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
                companyService.listAll().each { row ->
                    println """
                    Nome: ${row.name}
                    CNPJ: ${row.cnpj}
                    Email: ${row.email}
                    Description: ${row.description}
                    """
                }
                break

            case 2:
                candidateService.listAll().each { row ->
                    println """
                    Nome: ${row.first_name} ${row.last_name}
                    Email: ${row.email}
                    CPF: ${row.cpf}
                    Description: ${row.description}
                    """
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
                try {
                    companyService.create(company)
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
                try {
                    candidateService.create(candidate)
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