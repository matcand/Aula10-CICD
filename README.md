# 🚀 Pipeline de Integração Contínua (CI/CD) e Automação de Qualidade

![Java CI Pipeline](https://github.com/matcand/Aula10-CICD/actions/workflows/ci.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-17%20%7C%2025-ED8B00?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?logo=apachemaven&logoColor=white)
![JUnit 5](https://img.shields.io/badge/JUnit-5.11-25A162?logo=junit5&logoColor=white)
![Checkstyle](https://img.shields.io/badge/Checkstyle-Sun_Checks-4B8BBE)
![JaCoCo](https://img.shields.io/badge/JaCoCo-0.8.12-success)

Repositório dedicado à implementação prática de uma infraestrutura de **Integração Contínua (CI/CD)** em Java utilizando **GitHub Actions** e **Apache Maven**. O projeto automatiza a compilação, a execução de testes unitários, a auditoria de padronização de código (*Quality Gate*) e a geração de relatórios de cobertura a cada `push` ou `pull request`.

## 🏗️ Arquitetura da Pipeline de Qualidade

O fluxo de trabalho automatizado (`.github/workflows/ci.yml`) é disparado automaticamente em eventos de versionamento e executa validações sequenciais em um ambiente Linux (`ubuntu-latest`):

```mermaid
graph LR
    A[Commit / Push] --> B[Build Maven]
    B --> C[Testes Unitários JUnit 5]
    C --> D[Análise Estática Checkstyle]
    D --> E[Cobertura JaCoCo]
    E --> F{Passou?}
    F -->|Sim| G[Build Aprovado / Pronto para Deploy]
    F -->|Não| H[Bloqueio e Notificação de Falha]
```

## 🛠️ Estágios e Ferramentas Integradas

| Estágio | Ferramenta / Plugin | Objetivo na Pipeline |
| :--- | :--- | :--- |
| **1. Build** | Apache Maven | Compilação do código-fonte, empacotamento e resolução de dependências. |
| **2. Testes Unitários** | JUnit 5 (Jupiter) & Surefire | Validação automatizada das regras de negócio da aplicação. |
| **3. Quality Gate** | Maven Checkstyle (`sun_checks.xml`) | Análise estática rigorosa de formatação, Javadoc e boas práticas, bloqueando o build em caso de violações. |
| **4. Cobertura** | JaCoCo Maven Plugin | Instrumentação de bytecode e geração de relatório de cobertura de testes. |

## 📂 Estrutura do Projeto

```text
Aula10-CICD/
├── .github/
│   └── workflows/
│       └── ci.yml                      # Definição da pipeline no GitHub Actions
├── src/
│   ├── main/java/org/example/
│   │   ├── package-info.java           # Documentação do pacote exigida pelo Checkstyle
│   │   └── CalculadoraCI.java          # Classe de negócio auditada e documentada
│   └── test/java/org/example/
│       └── CalculadoraCITest.java      # Suíte de testes unitários com JUnit 5
└── pom.xml                             # Configuração de dependências, compilação e plugins
```

## 💻 Como Executar e Auditar Localmente

Para executar localmente a mesma esteira de validação que roda no servidor do GitHub Actions:

```bash
mvn clean test checkstyle:check jacoco:report
```

Após a conclusão com `BUILD SUCCESS`, o relatório visual de cobertura do JaCoCo pode ser consultado abrindo o arquivo `target/site/jacoco/index.html` no navegador.

## 👨‍💻 Autor

Desenvolvido por **Matheus Cândido** — Estudante de Informática para Negócios na **FATEC São Bernardo do Campo (Adib Moisés Dib)**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/matcand)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/matcand)