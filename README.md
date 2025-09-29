# 🏨 API de Gerenciamento de Reservas de Hotéis

Este projeto é uma **API RESTful** desenvolvida com **Spring Boot** sobre **reservas de hotéis** para o **Teste de Performance 3** da disciplina de **Desenvolvimento de Serviços Web e Testes com Java**.

## 🚀 Como configurar e executar o projeto

### Pré-requisitos

- Java 17+.
- Maven.

### Passos para execução

1.  **Clone o repositório**
    ```bash
    git clone https://github.com/LeticiaFAAGomes/Leticia_Ferreira_Augusto_Alves_Gomes_DR3_TP3.git
    cd HotelAPi
    ```
2.  Execute a aplicação

        mvn spring-boot:run

3.  Acesse a API

        http://localhost:8080/api/filmes

## 📍 Endpoints

### obterLista

| Método     | Tipo | URL                                 |
| ---------- | ---- | ----------------------------------- |
| obterLista | GET  | http://localhost:8080/api/reservas/ |

---

### Cadastrar Nova Reserva

| Método  | Tipo | URL                                 |
| ------- | ---- | ----------------------------------- |
| incluir | POST | http://localhost:8080/api/reservas/ |

#### Exemplo de JSON

```json
    {
        "titular": "Joana Barbosa",
        "numeroQuarto": 35,
        "tipoReserva": "INDIVIDUAL",
        "ehAtiva": true,
        "checkIn": "2025-10-01T14:00:00",
        "valorTotal": 450.0
    }
```

---

### Obter Reserva Por ID

| Método     | Tipo | URL                                     |
| ---------- | ---- | --------------------------------------- |
| obterPorId | GET  | http://localhost:8080/api/reservas/{id} |

---

### Alterar Dado de Reserva

| Método  | Tipo | URL                                     |
| ------- | ---- | --------------------------------------- |
| alterar | PUT  | http://localhost:8080/api/reservas/{id} |

#### Exemplo de JSON

```json
   {
        "id": 1,
        "titular": "Carlos Silva",
        "numeroQuarto": 35,
        "tipoReserva": "INDIVIDUAL",
        "ehAtiva": true,
        "checkIn": "2025-10-01T14:00:00",
        "valorTotal": 550.0
    }
```

---

### Excluir Reserva Pelo ID

| Método  | Tipo   | URL                                     |
| ------- | ------ | --------------------------------------- |
| excluir | DELETE | http://localhost:8080/api/reservas/{id} |

## 🧪 Testando com Postman

1. Configurar Coleção

   - Crie uma nova coleção no Postman chamada reservas-api.

   - Adicione os endpoints acima com os métodos e URLs correspondentes.

2. Teste o GET

   - Acesse /api/reservas e /api/reservas/{id}.

   - Verifique se os dados estão corretos.

3. Teste o POST

   - Envie o JSON de exemplo para /api/reservas.

   - Verifique se o status é 201 Created.

4. Teste o PUT

   - Atualize uma reservas com o JSON de exemplo.

   - Verifique se o status é 200 OK.

5. Teste o DELETE

   - Remova uma reservas existente.

   - Verifique se o status é 204 No Content.
