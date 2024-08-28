# Gestão de Tarefas
Este projeto é um gerenciador de tarefas desenvolvido utilizando JSF e Hibernate, com banco de dados PostgreSQL. O objetivo é fornecer uma aplicação web para criar, atualizar, remover e listar tarefas, com funcionalidades adicionais para filtrar e marcar tarefas como concluídas.

## Funcionalidades
- Cadastro de Tarefas: Permite criar novas tarefas com título, descrição, responsável, prioridade, deadline e status.
- Edição de Tarefas: Permite atualizar informações de tarefas existentes.
- Remoção de Tarefas: Permite excluir tarefas da lista.
- Listagem de Tarefas: Mostra todas as tarefas com opções de filtro por número, título, responsável e status.
- Marcar Tarefas como Concluídas: Permite marcar tarefas como concluídas a partir da listagem.

## Tecnologias Utilizadas
- Jakarta Faces (JSF): Para criação de interfaces web.
- Hibernate: Para mapeamento objeto-relacional e manipulação de dados.
- PostgreSQL: Banco de dados relacional.
- Jakarta EE: Plataforma para desenvolvimento de aplicações corporativas Java.
- WildFly: Servidor local.
- NetBeans 22: IDE.

## Dependências
- Jakarta Faces: Biblioteca responsável pela implementação da especificação JavaServer Faces (JSF), que é uma tecnologia para construção de interfaces web baseadas em Java. (Versão 4.0.0)
- Hibernate core: Framework de mapeamento objeto-relacional (ORM) para Java, que facilita a manipulação de dados em bancos de dados relacionais. (versão 6.2.0.Final)
- PostgreSQL Driver: Driver JDBC para conectar a aplicação ao banco de dados PostgreSQL. (versão 42.6.0)
- Jakarta EE API: Conjunto de especificações para a plataforma Jakarta EE, que fornece um ambiente completo para o desenvolvimento de aplicações corporativas. (versão 9.0.0-RC1)
- javax.faces-api: API antiga para JSF que pode ser necessária para compatibilidade com versões anteriores ou específicos requisitos. (versão 2.3)

## Instruções de Execução
1. Clone o repositório
   - git clone https://github.com/seu-usuario/nome-do-repositorio.git
   - cd nome-do-repositorio
   - Atualize o arquivo de configuração do projeto com as credenciais do banco de dados.
2. Configuração do Banco de Dados:
  - Certifique-se de ter o PostgreSQL instalado e em execução.
  - Crie um banco de dados para o projeto.
  - Atualize o arquivo de configuração do projeto com as credenciais do banco de dados.
3. Compilação e Execução:
  - Compile o projeto usando Maven:
  mvn clean install
  - Execute o projeto em um servidor de aplicação compatível, como o WildFly:
  mvn wildfly:run
4. Acessar a aplicação
  - Abra um navegador e acesse a aplicação em http://localhost:8080/nome-do-projeto.
