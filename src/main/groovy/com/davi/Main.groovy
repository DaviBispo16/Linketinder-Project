package com.davi

import com.davi.controller.CandidateController
import com.davi.controller.JobController
import com.davi.controller.SkillController
import com.davi.database.ConnectionFactory
import com.davi.database.DatabaseConnectionFactory
import com.davi.repository.CandidateRepository
import com.davi.repository.CompanyRepository
import com.davi.service.CandidateService
import com.davi.service.CompanyService
import com.davi.service.JobService
import com.davi.service.SkillService
import groovy.sql.Sql
import org.apache.catalina.Context
import org.apache.catalina.startup.Tomcat

import java.io.File

static void main(String[] args) {
    ConnectionFactory factory = DatabaseConnectionFactory.getFactory("postgres")
    Sql globalSql = factory.createConnection()

    def candidateRepo = new CandidateRepository(globalSql)

    CandidateService candidateService = new CandidateService(candidateRepo)
    SkillService skillService = new SkillService()
    JobService jobService = new JobService()

    Tomcat tomcat = new Tomcat()
    tomcat.setPort(8080)
    tomcat.getConnector()

    Context ctx = tomcat.addContext("", new File(".").getAbsolutePath())

    ctx.getServletContext().setAttribute("candidateService", candidateService)
    ctx.getServletContext().setAttribute("skillService", skillService)
    ctx.getServletContext().setAttribute("jobService", jobService)

    Tomcat.addServlet(ctx, "candidateController", new CandidateController())
    ctx.addServletMappingDecoded("/candidatos", "candidateController")

    Tomcat.addServlet(ctx, "skillController", new SkillController())
    ctx.addServletMappingDecoded("/skills", "skillController")

    Tomcat.addServlet(ctx, "jobController", new JobController())
    ctx.addServletMappingDecoded("/vagas", "jobController")

    println "Iniciando servidor Tomcat na porta 8080..."
    tomcat.start()
    tomcat.getServer().await()
}