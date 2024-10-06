# JAVA-ADVANCED
# OdontoPredict

## Descrição

O **OdontoPredict** é uma aplicação Java que utiliza análise preditiva para identificar comportamentos de risco em pacientes e dentistas. O sistema tem como objetivo antecipar a necessidade de intervenções preventivas na área de odontologia.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Hibernate
- JPA
- Lombok

## Estrutura do Projeto

### Pacotes Principais

- **controller**: Contém as classes responsáveis por gerenciar as requisições HTTP.
- **service**: Implementa a lógica de negócios do sistema.
- **repository**: Contém interfaces que estendem o `JpaRepository`, permitindo a interação com o banco de dados.
- **model**: Classes que representam as entidades do domínio do sistema.

### Classes Principais

#### Paciente

A classe `Paciente` representa um paciente no sistema. Ela contém os atributos como `idPaciente`, `nome` e `dataNascimento`.

#### Dentista

A classe `Dentista` representa um dentista no sistema. Os atributos incluem `idDentista`, `nome` e `especializacao`.

### Controladores

#### PacienteController

Gerencia as requisições relacionadas aos pacientes, permitindo criar novos pacientes e obter informações sobre pacientes existentes.

#### DentistaController

Gerencia as requisições relacionadas aos dentistas, permitindo criar novos dentistas e obter informações sobre dentistas existentes.

### Serviços

#### PacienteService

Implementa a lógica de negócios para gerenciar pacientes, permitindo a criação de novos pacientes e a busca de pacientes existentes.

#### DentistaService

Implementa a lógica de negócios para gerenciar dentistas, permitindo a criação de novos dentistas e a busca de dentistas existentes.

## Conclusão

O OdontoPredict busca oferecer uma estrutura robusta e eficiente para a identificação de comportamentos de risco na odontologia, permitindo que dentistas realizem intervenções preventivas mais eficazes.

## Como Executar o Projeto

1. Clone este repositório.
2. Certifique-se de ter o Java e o Maven instalados.
3. Navegue até o diretório do projeto.
4. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
