# Trabalho Final de POO

Este é o trabalho final para a disciplina de Programação Orientada a Objeto, de segundo semestre.

O objetivo do trabalho é implementar um sistema de gerenciamento de eventos, equipes, equipamentos e atendimentos, capaz de atender as necessidades de uma empresa que oferece serviços de atendimento a desastres naturais em eventos como ciclones, terremotos e secas. Para os atendimentos a empresa possui várias equipes e equipamentos distribuídos pelo mundo.

O trabalho também visa a implementação dos conceitos vistos na disciplina, contendo tratamento de exceções, uso de interface gráfica com o usuário, uso de herança, polimorfismo e coleções.

## Descrição geral

Todo evento possui um código único, uma data e uma localização (latitude e longitude). Um evento pode ser: ***Ciclone, terremoto ou seca.***
  
Uma equipe possui um codinome único, uma quantidade de membros e a sua localização (latitude e longitude). Uma equipe pode ter vários equipamentos. Uma equipe só consegue atender eventos até 5.000 quilômetros de distância.

Um equipamento possui um identificador único, um nome e o valor de custo por dia. Um equipamento pode ser: ***Barco, caminhão tanque ou escavadeira.***

Cada atendimento possui um código único, uma data de início e uma duração (em dias). Um atendimento possui um evento e pode ter uma equipe alocada.
- Um atendimento pode estar em um dos estados (status): PENDENTE, EXECUTANDO, FINALIZADO, CANCELADO.
- Quando um atendimento é criado fica no estado PENDENTE, quando há uma equipe é alocada fica no estado EXECUTANDO, quando o atendimento termina fica no estado FINALIZADO. A qualquer momento atendimento pode ser CANCELADO.
