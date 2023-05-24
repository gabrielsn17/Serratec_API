# Serratec_API

## Exercício 3: Planetário Serratec
### Motivações:
A ideia foi fazer o projeto sobre algo que eu goste muito, astronomia.
No projeto você pode listar todos plantes do Sistema Solar incluindo os planetas anões, também pode listar nossa estrela e informações em geral<br>
### As informações listadas sobre cada corpo celeste são: 
* nome;
* diâmetro equatorial;
* inclinação;
* gravidade;
* tipo;
* possui lua;
* duração do dia;
* quantidade de luas;

### No Postman, 7 requisições foram criadas:
* Listar todos (Retorna todos os objetos cadastrados no banco de dados)
* Inserir novo (Vai que encontramos outro planeta anão...)
* Listar por Id (Retorna uma lista formatada com as unidades de medidas relacionadas a cada informação)
* Listar por tipo (Deve passar como parâmetro o tipo (estrela, planeta, gasoso, anao), retorna os objetos)
* Informações (Página destinada a informações como, número de planetas, estrelas e etc)
* Atualizar corpo celeste por Id (Se plutão voltar a ser planeta, podemos atualizar)
* Deletar por Id (Espero nunca usar este...)

Tratamento de erros: não pode inserir se já existe, não encontrará nenhum Id que não existe.
### Ideais futuras:
Criar uma página  HTLM onde estes dados aparecam ao lado de cada corpo celeste animado com CSS (animação já está pronta)
