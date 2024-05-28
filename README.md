# texo-challenge-api

### API RESTful para o Golden Raspberry Awards

Esta é uma API RESTful desenvolvida em Spring Boot e Java 17 para possibilitar a leitura da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.

### Requisitos do Sistema

1. Ler o arquivo CSV dos filmes e inserir os dados em uma base de dados ao iniciar a aplicação.

### Requisitos da API

1. Obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que obteve dois prêmios mais rápido, seguindo a especificação de formato definida na página 2.

### Requisitos Não Funcionais do Sistema

1. O web service RESTful é implementado com base no nível 2 de maturidade de Richardson.
2. Somente testes de integração são implementados para garantir que os dados obtidos estão de acordo com os dados fornecidos na proposta.
3. O banco de dados está em memória utilizando um SGBD embarcado (por exemplo, H2). Nenhuma instalação externa é necessária.
4. A aplicação contém um README com instruções para rodar o projeto e os testes de integração.

### Como Rodar o Projeto

Executar 

### Pré-requisitos

Certifique-se de ter instalado:

- Java Development Kit (JDK) 17 ou superior
- Maven

###Passos para Executar

1. Clone este repositório:

git clone https://github.com/seu-usuario/nome-do-repositorio.git

arduino
Copiar código

2. Navegue até o diretório do projeto:

cd nome-do-repositorio

markdown
Copiar código

3. Compile o projeto com Maven:

mvn clean install

css
Copiar código

4. Execute a aplicação:

mvn spring-boot

lua
Copiar código

### Como Executar os Testes de Integração

1. Após clonar o repositório e navegar até o diretório do projeto, certifique-se de que a aplicação está em execução (consulte os passos acima).
2. Execute os testes de integração com o Maven:

mvn integration-test

csharp
Copiar código

### Endpoints da API

Os endpoints da API podem ser acessados através do seguinte URL base:

http://localhost:8080/api

css
Copiar código

A documentação detalhada dos endpoints estará disponível aqui.

### Documentação da API

A documentação da API estará disponível aqui.
