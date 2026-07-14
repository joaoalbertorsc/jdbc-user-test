# Teste de Conexão e Operações JDBC em Java ☕

## 📝 Sobre o Projeto

Este repositório contém uma aplicação prática voltada para testes de integração e persistência de dados utilizando o **JDBC (Java Database Connectivity)**. O projeto simula o gerenciamento e testes de uma entidade de usuário, realizando a comunicação direta com o banco de dados relacional sem a necessidade de frameworks ORM pesados.

O foco principal é ilustrar o fluxo clássico de conexão, manipulação de dados em baixo nível e a garantia de fechamento correto de recursos de rede e banco de dados.

## 💡 Principais Conceitos Abordados

* **Driver Manager e Conectividade:** Como registrar o driver do banco de dados e estabelecer conexões ativas utilizando a classe `DriverManager` e a interface `Connection`.
* **Prevenção de SQL Injection com `PreparedStatement`:** Uso de consultas parametrizadas para garantir a segurança da aplicação ao inserir, atualizar e buscar usuários no banco.
* **Processamento de Resultados com `ResultSet`:** Como iterar sobre as linhas retornadas do banco de dados, convertendo tipos relacionais diretamente para objetos Java de forma manual.
* **Gerenciamento de Recursos (Try-with-Resources):** Aplicação de boas práticas do Java moderno para garantir o fechamento seguro de conexões, statements e result sets, evitando vazamentos de memória (memory leaks).

## 🛠️ Tecnologias Utilizadas

* Java (versão 17 ou superior recomendada)
* Driver JDBC (MySQL, PostgreSQL ou H2 conforme configuração do projeto)
* Maven (gerenciador de dependências e build)

---

## 🚀 Como Executar o Projeto

Você pode rodar os testes e as operações JDBC tanto diretamente pelo terminal quanto utilizando a sua IDE preferida.

### 📋 Pré-requisitos

Certifique-se de ter instalado em sua máquina:

* **Java JDK** (versão 17 ou superior) configurado no seu sistema (`JAVA_HOME`).
* **Apache Maven** instalado (ou utilize o Maven Wrapper `./mvnw` se disponível).
* **Banco de Dados** compatível rodando (localmente ou via Docker).
* **Aviso de Configuração:** Verifique os parâmetros de conexão (como URL de conexão JDBC, usuário e senha) definidos no código ou no arquivo de propriedades para alinhá-los com o seu ambiente de testes local.

### 💻 Opção 1: Executando pelo Terminal (Sem IDE)

Siga os passos abaixo para compilar e rodar a aplicação através do terminal:

1. **Clone o repositório:**
```bash
git clone https://github.com/joaoalbertorsc/jdbc-user-test.git
cd jdbc-user-test

```


2. **Limpe e Compile o projeto:**
Este comando baixa o driver JDBC necessário e compila os fontes do projeto:
```bash
mvn clean compile

```


3. **Execute a aplicação:**
* Se o projeto possuir uma classe principal configurada no `pom.xml`, execute:
```bash
mvn exec:java

```


* Para especificar manualmente a classe de testes ou de execução principal:
```bash
mvn exec:java -Dexec.mainClass="com.seuprojeto.Main"

```




4. **Execute os Testes Unitários/Integração:**
Se o projeto tiver uma suíte de testes preparada para verificar a inserção e busca de usuários no banco:
```bash
mvn test

```



### 🖥️ Opção 2: Executando via IDE (IntelliJ IDEA, Eclipse, VS Code)

Para visualizar melhor o fluxo de dados e debugar as operações:

1. **Importar o Projeto:**
* Abra a sua IDE.
* Selecione **Open** ou **Import Project**.
* Escolha o arquivo `pom.xml` na raiz do diretório para carregar todas as dependências do Maven.


2. **Executar:**
* Localize a classe que contém o método `main` responsável por rodar os testes de inserção e busca do usuário.
* Clique com o botão direito sobre ela e selecione **Run**.


3. **Debugar a Conexão:**
* Caso queira entender como o JDBC gerencia o ciclo de vida da conexão, coloque um *breakpoint* logo antes da abertura do bloco `try (Connection conn = ...)` e use o modo de depuração para acompanhar a criação do socket com o banco de dados.



---

## 👨‍💻 Autor

**João Alberto** – Engenheiro de Software

---

*Se este projeto te ajudou a entender como funciona a comunicação nativa em Java com bancos de dados via JDBC, sinta-se à vontade para deixar uma ⭐ no repositório!*
