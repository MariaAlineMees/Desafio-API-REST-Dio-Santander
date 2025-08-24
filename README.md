# Santander Dio - API de Gerenciamento de Usuários

Este projeto foi desenvolvido durante o bootcamp da DIO em parceria com o Santander, com o objetivo de criar uma API RESTful para gerenciamento de usuários de um banco digital.

## 🚀 Visão Geral

A API permite o gerenciamento completo de usuários, incluindo suas contas bancárias, cartões, recursos e notícias. Desenvolvida com Spring Boot 3 e Java 17, a aplicação segue as melhores práticas de desenvolvimento de software.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database** (embutida para desenvolvimento)
- **OpenAPI/Swagger** para documentação
- **Lombok** para redução de boilerplate
- **MapStruct** para mapeamento de objetos
- **Bean Validation** para validação de dados

## 📋 Funcionalidades Principais

- ✅ Cadastro e gerenciamento de usuários
- ✅ Controle de contas bancárias
- ✅ Gerenciamento de cartões
- ✅ Recursos e notícias personalizadas
- ✅ Documentação completa da API via Swagger


## ✨ Melhorias Implementadas

### 1. UserController
- Documentação Swagger aprimorada
- Validações de entrada
- Respostas HTTP mais descritivas

### 2. Entidade User
- Relacionamentos otimizados com `FetchType.LAZY`
- Validações de campos
- Padrão Builder para criação de instâncias

### 3. UserDto
- Uso de records para imutabilidade
- Documentação Swagger detalhada
- Métodos de conversão melhorados

### 4. Estrutura do Projeto
- Separação clara de responsabilidades
- Tratamento centralizado de exceções
- Código mais limpo e organizado

## 🚀 Como Executar

1. Clone o repositório
2. Execute `./mvnw spring-boot:run`
3. Acesse a documentação em: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 🔍 Testando a API

Acesse o Swagger UI para testar os endpoints disponíveis:
- `GET /users` - Lista todos os usuários
- `POST /users` - Cria um novo usuário
- `GET /users/{id}` - Busca um usuário por ID
- `PUT /users/{id}` - Atualiza um usuário
- `DELETE /users/{id}` - Remove um usuário

## 📈 Próximas Melhorias

### Prioridade Alta
- [ ] Implementar autenticação JWT
- [ ] Adicionar testes unitários e de integração
- [ ] Implementar paginação nas consultas

### Prioridade Média
- [ ] Adicionar cache com Redis
- [ ] Implementar upload de imagem de perfil
- [ ] Melhorar mensagens de erro

### Prioridade Baixa
- [ ] Adicionar suporte a i18n
- [ ] Implementar documentação adicional
- [ ] Configurar CI/CD

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

👩🏻‍💻 Desenvolvido por Maria Aline Mees durante o bootcamp Santander/DIO 2025
