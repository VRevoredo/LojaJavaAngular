import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { ClientesComponent } from './components/clientes/clientes.component';
import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter([
      { path: '', component: ClientesComponent }, // Mapeia a raiz para ClientesComponent
      { path: '**', redirectTo: '' } // Redireciona qualquer rota inválida para a raiz
    ]),
    provideHttpClient() // Habilita o uso de HttpClient para chamadas à API
  ]
};
