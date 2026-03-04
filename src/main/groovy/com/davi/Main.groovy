package com.davi

import com.davi.model.Candidate
import com.davi.model.Company
import com.davi.service.CandidateService
import com.davi.service.CompanyService

static void main(String[] args) {
    CompanyService companyService = new CompanyService()
    CandidateService candidateService = new CandidateService()

    List<Candidate> candidates = [
            candidateService.create(new Candidate('Lucas Mateus',   'lucas.mateus@example.com',   'BA', '40000-000', 'QA / test automation','123.456.789-09', 27)),
            candidateService.create(new Candidate('Mariana Silva',  'mariana.silva@example.com',  'SP', '01000-000', 'Backend developer (APIs)', '987.654.321-00', 24)),
            candidateService.create(new Candidate('Rafael Souza',   'rafael.souza@example.com',   'RJ', '20000-000', 'Software engineer (architecture)','741.852.963-11', 31)),
            candidateService.create(new Candidate('Camila Oliveira','camila.oliveira@example.com','MG', '30000-000', 'Product designer (UX/UI)', '159.357.258-22', 29)),
            candidateService.create(new Candidate('Bruno Almeida',  'bruno.almeida@example.com',  'RS', '90000-000', 'DevOps (pipelines/containers)', '456.789.123-33', 26)),
    ]

    List<Company> companies = [
            companyService.create(new Company('FlowTech Solutions',   'contato@flowtech.example',   'SP', '01000-000', 'Software house focada em integração e automação.', '12.345.678/0001-90', 'Brazil')),
            companyService.create(new Company('Bahia Payments',       'suporte@bahiapay.example',   'BA', '40000-000', 'Serviços de pagamento e adquirência para varejo.',  '98.765.432/0001-10', 'Brazil')),
            companyService.create(new Company('Rio Data Lab',         'hello@riodatalab.example',   'RJ', '20000-000', 'Consultoria em dados, BI e observabilidade.', '45.678.912/0001-33', 'Brazil')),
            companyService.create(new Company('Minas Cloud Ops',      'ops@minascloud.example',     'MG', '30000-000', 'DevOps e cloud para empresas de médio porte.', '56.789.123/0001-44', 'Brazil')),
            companyService.create(new Company('Sul Commerce Group',   'vendas@sulcommerce.example', 'RS', '90000-000', 'Plataforma de e-commerce e logística integrada.', '67.891.234/0001-55', 'Brazil'))
    ]

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
                companyService.listAll().each { Company c ->
                    println """
                    Nome: ${c.name}
                    Email: ${c.email}
                    Estado: ${c.state}
                    CEP: ${c.zipCode}
                    Description: ${c.description}
                    CNPJ: ${c.cnpj}
                    País: ${c.country}
                    """
                }
                break

            case 2:
                candidateService.listAll().each {Candidate c ->
                    println """
                    Nome: ${c.name}
                    Email: ${c.email}
                    Estado: ${c.state}
                    CEP: ${c.zipCode}
                    Description: ${c.description}
                    CPF: ${c.cpf}
                    Idade: ${c.age}
                    """
                }
                break

            case 3:
                println("Nome:")
                String name = scanner.nextLine()

                println("E-mail:")
                String email = scanner.nextLine()

                println("Estado (UF):")
                String state = scanner.nextLine()

                println("CEP:")
                String zipCode = scanner.nextLine()

                println("Descrição:")
                String description = scanner.nextLine()

                println("CNPJ:")
                String cnpj = scanner.nextLine()

                println("País:")
                String country = scanner.nextLine()

                Company company = new Company(name, email, state, zipCode, description, cnpj, country)
                companyService.create(company)
                println "Empresa ${company.name} cadastrada"
                break

            case 4:
                println("Nome:")
                String name = scanner.nextLine()

                println("E-mail:")
                String email = scanner.nextLine()

                println("Estado (UF):")
                String state = scanner.nextLine()

                println("CEP:")
                String zipCode = scanner.nextLine()

                println("Descrição:")
                String description = scanner.nextLine()

                println("CPF:")
                String cpf = scanner.nextLine()

                println("Age:")
                int age = scanner.nextInt()

                Candidate candidate = new Candidate(name, email, state, zipCode, description, cpf, age)
                candidateService.create(candidate)
                println "Candidato ${candidate.name} cadastrado!"
                break

            default:
                println "Opção inválida, tente novamente"
        }
    }

}