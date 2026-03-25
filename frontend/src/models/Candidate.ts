export interface Candidate {
    name: string;
    email: string;
    cpf: string;
    age: number;
    state: string;
    cep: string;
    description: string;
    education: string;
    skills: string[];
}

export const CandidateRegex = {
    name: /^[A-Za-zÀ-ÖØ-öø-ÿ\s]{2,}$/,
    email: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
    cpf: /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/,
    state: /^[A-Z]{2}$/i,
    cep: /^\d{5}-?\d{3}$/
};
