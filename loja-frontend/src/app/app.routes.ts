import { Routes } from '@angular/router';
import { ClientesComponent } from './components/clientes/clientes.component';

export const routes: Routes = [
  { path: '', component: ClientesComponent}, // Mapeia a URL raiz para ClientesComponent
  { path: '**', redirectTo: '' } // Redireciona URLs não encontradas para a raiz
];
