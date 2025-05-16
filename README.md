# Hibernate One-to-Many Mapping Example

This project demonstrates how to implement a **One-to-Many** relationship in Hibernate using two entities: `QuestionTable` and `AnswerTable`.

---

## Overview

- One `QuestionTable` entity can have multiple `AnswerTable` entities.
- This models a typical question and multiple answers scenario.
- The relationship is bidirectional and mapped using Hibernate annotations.
- The project fetches a question and its associated answers from the database.

---

## Technologies Used

- Java
- Hibernate ORM
- Jakarta Persistence API (JPA)
- Relational Database (MySQL)
- Maven (optional)

---

## How It Works

1. **Configuration**

   Hibernate is configured via `hibernate.cfg.xml`.

2. **Session and Transaction**

   A Hibernate `Session` is opened and a transaction begins.

3. **Fetching Data**

   The code fetches a `QuestionTable` object by its primary key.

4. **Accessing Answers**

   The associated list of `AnswerTable` objects is retrieved and iterated to print all answers linked to the question.

5. **Transaction Handling**

   Transaction commits or rolls back based on success.

6. **Closing Resources**

   Sessions and session factories are properly closed to avoid resource leaks.

---

## Example Code Snippet

```java
QuestionTable question = session.get(QuestionTable.class, 1);
System.out.println(question.getQuestion());

for (AnswerTable answer : question.getAnswerList()) {
    System.out.println(answer.getAnswer());
}

