import { Candidate } from '../models/Candidate.js';
import { Company } from '../models/Company.js';
import { mockCandidates, mockJobs } from './MockData.js';

export class RegistrationService {
    constructor() {
        this.init();
        this.renderLists();
    }

    private init() {
        const candidateForm = document.getElementById('candidate-form') as HTMLFormElement;
        const companyForm = document.getElementById('company-form') as HTMLFormElement;

        candidateForm.addEventListener('submit', (e) => this.handleCandidateSubmit(e));
        companyForm.addEventListener('submit', (e) => this.handleCompanySubmit(e));
    }

    private renderLists() {
        this.renderJobs();
        this.renderAnonymousCandidates();
    }

    private renderJobs() {
        const jobList = document.getElementById('job-list');
        if (!jobList) return;

        jobList.innerHTML = mockJobs.map(job => `
            <div class="card">
                <h4>${job.title}</h4>
                <p><strong>${job.companyName}</strong></p>
                <p>${job.description}</p>
                <div class="skills-tags">
                    ${job.skillsRequired.map(s => `<span class="tag">${s}</span>`).join('')}
                </div>
            </div>
        `).join('');
    }

    private renderAnonymousCandidates() {
        const candidateList = document.getElementById('candidate-list');
        if (!candidateList) return;

        candidateList.innerHTML = mockCandidates.map(c => `
            <div class="card">
                <h4>Candidato (Anônimo)</h4>
                <p><strong>Formação:</strong> ${c.education}</p>
                <div class="skills-tags">
                    ${c.skills.map(s => `<span class="tag">${s}</span>`).join('')}
                </div>
            </div>
        `).join('');
    }

    private handleCandidateSubmit(e: Event) {
        e.preventDefault();
        const form = e.target as HTMLFormElement;
        const formData = new FormData(form);

        const candidate: Candidate = {
            name: formData.get('name') as string,
            email: formData.get('email') as string,
            cpf: formData.get('cpf') as string,
            age: Number(formData.get('age')),
            state: formData.get('state') as string,
            cep: formData.get('cep') as string,
            description: formData.get('description') as string,
            education: formData.get('education') as string,
            skills: (formData.get('skills') as string).split(',').map(s => s.trim())
        };

        console.log('Candidato Cadastrado:', JSON.stringify(candidate, null, 2));
        alert('Candidato cadastrado com sucesso!');
    }

    private handleCompanySubmit(e: Event) {
        e.preventDefault();
        const form = e.target as HTMLFormElement;
        const formData = new FormData(form);

        const company: Company = {
            name: formData.get('name') as string,
            email: formData.get('email') as string,
            cnpj: formData.get('cnpj') as string,
            country: formData.get('country') as string,
            state: formData.get('state') as string,
            cep: formData.get('cep') as string,
            description: formData.get('description') as string
        };

        console.log('Empresa Cadastrada:', JSON.stringify(company, null, 2));
        alert('Empresa cadastrada com sucesso!');
    }
}
