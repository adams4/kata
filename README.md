# Kata - Spring Boot MVC

Ce projet est une implémentation du **Bank Account Kata** en Java avec **Spring Boot**, utilisant une architecture **MVC (Modèle - Vue - Contrôleur)**.

Il permet :
-  de faire des dépôts
-  de faire des retraits
-  de consulter le solde
-  d'avoir le relevé de compte

---

## Technologies utilisées

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Base H2 (in-memory)
- JUnit 5 & Mockito
- Maven

---

## Installation

```bash
git clone https://github.com/adams4/kata.git
cd kata
./mvnw clean install
```

---

## Lancement de l'application

```bash
./mvnw spring-boot:run
```

Accessible sur : `http://localhost:8080`

---

## API REST - Endpoints

| Méthode | Endpoint                             | Description                     |
|---------|--------------------------------------|---------------------------------|
| `POST`  | `/account/deposit?amount=1000`       | Effectue un dépôt               |
| `POST`  | `/account/withdraw?amount=300`       | Effectue un retrait             |
| `GET`   | `/account/balance`                   | Consulte le solde               |
| `GET`   | `/account/statement`                 | Relevé des transactions         |

---

## Tests

### Lancer tous les tests

```bash
./mvnw test
```

- `BankAccountServiceTest` - tests unitaires
- `BankApplicationTests` - tests d’intégration (base H2)

---

## Licence

Free Project.