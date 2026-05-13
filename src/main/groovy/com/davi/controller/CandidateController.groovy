package com.davi.controller

import com.davi.model.Candidate
import com.davi.service.CandidateService
import com.google.gson.Gson

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

class CandidateController extends HttpServlet {
    private final Gson gson = new Gson()

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateService candidateService = (CandidateService) getServletContext().getAttribute("candidateService")
        
        try {
            Candidate candidateFromJson = gson.fromJson(req.getReader(), Candidate.class)
            Candidate newCandidate = new Candidate(
                    candidateFromJson.first_name,
                    candidateFromJson.last_name,
                    candidateFromJson.email,
                    candidateFromJson.cpf,
                    candidateFromJson.description,
                    candidateFromJson.password,
                    candidateFromJson.location_id
            )
            Candidate createdCandidate = candidateService.create(newCandidate)
            
            resp.setContentType("application/json")
            resp.setStatus(HttpServletResponse.SC_CREATED)
            resp.getWriter().write(gson.toJson(createdCandidate))
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST)
            resp.getWriter().write("{\"error\": \"${e.message}\"}")
        }
    }
}
