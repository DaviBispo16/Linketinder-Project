export interface Company {
    name: string;
    email: string;
    cnpj: string;
    country: string;
    state: string;
    cep: string;
    description: string;
}

export const CompanyRegex = {
    name: /^[A-Za-zÀ-ÖØ-öø-ÿ\s]{2,}$/,
    email: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/,
    cnpj: /^\d{2}\.?\d{3}\.?\d{3}\/?\d{4}-?\d{2}$/,
    country: /^[A-Za-zÀ-ÖØ-öø-ÿ\s]{2,}$/,
    state: /^[A-Z]{2}$/i,
    cep: /^\d{5}-?\d{3}$/,
    description: /^.{10,}$/
}