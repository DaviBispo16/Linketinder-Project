import { navigation } from './ui/navigation.js';
import { RegistrationService } from './services/RegistrationService.js';

document.addEventListener('DOMContentLoaded', () => {
    console.log('Linketinder Iniciado');
    new navigation();
    new RegistrationService();
});
