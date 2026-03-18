export class navigation {
    private candidateSection: HTMLElement;
    private companySection: HTMLElement;
    private navCandidateBtn: HTMLButtonElement;
    private navCompanyBtn: HTMLButtonElement;

    constructor() {
        this.candidateSection = document.getElementById('candidate-section')!;
        this.companySection = document.getElementById('company-section')!;
        this.navCandidateBtn = document.getElementById('nav-candidate') as HTMLButtonElement;
        this.navCompanyBtn = document.getElementById('nav-company') as HTMLButtonElement;

        this.init();
    }

    private init() {
        this.navCandidateBtn.addEventListener('click', () => this.showCandidateForm());
        this.navCompanyBtn.addEventListener('click', () => this.showCompanyForm());
    }

    private showCandidateForm() {
        this.candidateSection.classList.remove('hidden');
        this.companySection.classList.add('hidden');
        this.navCandidateBtn.classList.add('active');
        this.navCompanyBtn.classList.remove('active');
    }

    private showCompanyForm() {
        this.companySection.classList.remove('hidden');
        this.candidateSection.classList.add('hidden');
        this.navCompanyBtn.classList.add('active');
        this.navCandidateBtn.classList.remove('active');
    }
}
