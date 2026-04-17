# Trabalho_faculdade-quadraEsportiva

# Sistema de Controle de Aluguel de Quadra Esportiva

## Descrição do Sistema

O sistema foi desenvolvido para substituir o controle manual de aluguéis de uma quadra de futebol society.

Permite cadastrar clientes, registrar aluguéis por data e horário, verificar disponibilidade automaticamente e evitar conflitos de agendamento.

---

## Tabelas Identificadas

### Cliente
Armazena os dados dos clientes.

| Campo     | Tipo    | Descrição              |
|----------|--------|------------------------|
| nome     | String | Nome do cliente        |
| telefone | String | Telefone do cliente    |

---

### Aluguel
Representa uma reserva da quadra.

| Campo            | Tipo       | Descrição                          |
|------------------|-----------|----------------------------------|
| cliente          | Cliente   | Cliente que realizou a reserva   |
| data             | LocalDate | Data do aluguel                  |
| horaInicio       | LocalTime | Horário inicial                  |
| duracaoMinutos   | int       | Duração da reserva em minutos    |

---

### Horario
Representa um horário base com valor.

| Campo | Tipo   | Descrição              |
|------|-------|------------------------|
| hora | String| Horário (ex: 08:00)    |
| valor| double| Valor do horário       |

---

### Quadra
Gerencia clientes e aluguéis.

| Campo   | Tipo            | Descrição                    |
|--------|-----------------|------------------------------|
| clientes| Lista<Cliente> | Lista de clientes cadastrados|
| alugueis| Lista<Aluguel> | Lista de reservas realizadas |

---

## Regras de Negócio

RN01 — Nome do cliente é obrigatório  
Não é permitido cadastrar clientes com nome vazio.

RN02 — Valor do horário não pode ser negativo  
O sistema não permite cadastrar horários com valor negativo.

RN03 — Cliente deve existir para registrar aluguel  
Só é possível registrar aluguel para clientes cadastrados.

RN04 — Verificação de conflito de horário  
O sistema não permite sobreposição de horários no mesmo dia.

RN05 — Cálculo automático do valor  
O valor do aluguel é calculado automaticamente com base na duração.

RN06 — Cálculo proporcional por tempo  
O valor é calculado proporcionalmente aos minutos alugados.

RN07 — Consulta por data  
O sistema permite listar todos os aluguéis de uma data.

RN08 — Consulta por nome  
Permite buscar aluguéis realizados por um cliente específico.

RN09 — Agenda do dia  
O sistema exibe horários livres e ocupados em intervalos de 30 minutos.

RN10 — Um cliente pode ter múltiplos aluguéis  
O sistema permite várias reservas para o mesmo cliente.

RN11 — Controle de intervalo de horários  
Um aluguel possui início e fim calculado automaticamente.

RN12 — Validação de sobreposição  
Um horário é considerado ocupado se houver interseção de tempo entre reservas.

---

## Estrutura dos Projetos

QuadraEsportiva/  
├── src/  
│   ├── Cliente.java  
│   ├── Horario.java  
│   ├── Aluguel.java  
│   ├── Quadra.java  
│   └── Main.java  

---

QuadraEsportiva_MVC/  
├── controller/  
│   └── SistemaController.java  
├── model/  
│   ├── Cliente.java  
│   ├── Horario.java  
│   ├── Aluguel.java  
│   ├── Quadra.java  
├── view/  
│   └── SistemaView.java  
└── Main.java  
