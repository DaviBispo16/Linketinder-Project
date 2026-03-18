import { Candidate } from '../models/Candidate';
import { Job } from '../models/Job';

export const mockCandidates: Candidate[] = [
    {
        name: "João Silva",
        email: "joao@email.com",
        cpf: "123.456.789-00",
        age: 25,
        state: "SP",
        cep: "01000-000",
        description: "Desenvolvedor Fullstack apaixonado por TypeScript.",
        education: "Ciência da Computação - USP",
        skills: ["TypeScript", "Node.js", "React"]
    },
    {
        name: "Maria Oliveira",
        email: "maria@email.com",
        cpf: "987.654.321-11",
        age: 28,
        state: "RJ",
        cep: "20000-000",
        description: "Especialista em UI/UX e CSS Moderno.",
        education: "Design Gráfico - UFRJ",
        skills: ["CSS", "Figma", "Accessibility"]
    }
];

export const mockJobs: Job[] = [
    {
        id: 1,
        title: "Desenvolvedor Frontend Sênior",
        description: "Buscamos especialista em React e TypeScript para projeto inovador.",
        companyName: "Tech Giants",
        skillsRequired: ["React", "TypeScript", "Tailwind"]
    },
    {
        id: 2,
        title: "Desenvolvedor Node.js",
        description: "Oportunidade para backend focado em performance e escalabilidade.",
        companyName: "Cloud Systems",
        skillsRequired: ["Node.js", "Express", "PostgreSQL"]
    }
];
