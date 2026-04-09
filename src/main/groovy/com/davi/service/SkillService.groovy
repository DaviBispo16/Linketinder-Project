package com.davi.service

import com.davi.model.Skill

class SkillService {
    private List<Skill> skills = []

    Skill create(Skill newSkill) {
        skills << newSkill
        return newSkill
    }

    List<Skill> listAll() {
        return skills
    }
}
