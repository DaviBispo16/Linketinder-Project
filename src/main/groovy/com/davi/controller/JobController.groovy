package com.davi.controller

import com.davi.service.JobService
import com.google.gson.Gson

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

class JobController extends HttpServlet {
    private final Gson gson = new Gson()

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JobService jobService = (JobService) getServletContext().getAttribute("jobService")
        
        try {
            resp.setContentType("application/json")
            resp.setStatus(HttpServletResponse.SC_OK)
            resp.getWriter().write(gson.toJson(jobService.listAll()))
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR)
            resp.getWriter().write("{\"error\": \"${e.message}\"}")
        }
    }
}
