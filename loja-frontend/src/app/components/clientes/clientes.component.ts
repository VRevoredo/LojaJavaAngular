import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.less']
})
export class ClientesComponent implements OnInit {
  clientes: any[] = []; // Inicializa com array vazio

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.carregarClientes();
  }

  carregarClientes(): void {
    this.http.get<any[]>('http://localhost:8080/clientes')
      .subscribe(
        (data) => {
          this.clientes = data; // Atualiza o array com os dados recebidos
        },
        (error) => {
          console.error('Erro ao carregar clientes:', error);
          this.clientes = []; // Certifica-se de manter o array vazio em caso de erro
        }
      );
  }
}