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
    // Validates letters (including accents) and spaces.
    name: /^[A-Za-zÀ-ÖØ-öø-ÿ\s]{2,}$/,
    // Standard email validation.
    email: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
    // Validates CPF with or without punctuation (e.g., 123.456.789-00 or 12345678900).
    cpf: /^\d{3}\.?\d{3}\.?\d{3}-?\d{2}$/,
    // Validates Brazilian state abbreviations (exactly 2 characters).
    state: /^[A-Z]{2}$/i,
    // Validates CEP with or without hyphen (e.g., 12345-678 or 12345678).
    cep: /^\d{5}-?\d{3}$/
};
