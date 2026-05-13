package com.davi.controller

import com.davi.model.Skill
import com.davi.service.SkillService
import com.google.gson.Gson

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

class SkillController extends HttpServlet {
    private final Gson gson = new Gson()

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SkillService skillService = (SkillService) getServletContext().getAttribute("skillService")
        
        try {
            Skill skillFromJson = gson.fromJson(req.getReader(), Skill.class)
            Skill newSkill = new Skill(skillFromJson.name)
            Skill createdSkill = skillService.create(newSkill)
            
            resp.setContentType("application/json")
            resp.setStatus(HttpServletResponse.SC_CREATED)
            resp.getWriter().write(gson.toJson(createdSkill))
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST)
            resp.getWriter().write("{\"error\": \"${e.message}\"}")
        }
    }
}
