# API Testing Project – ReqRes API

## Descriere proiect

Acest proiect conține teste automate API dezvoltate folosind:

- Java 11
- RestAssured
- TestNG
- Maven

Scopul proiectului este validarea funcționalităților principale oferite de API-ul ReqRes:
- autentificare utilizator
- obținere listă utilizatori
- creare utilizator
- actualizare utilizator
- ștergere utilizator
- validarea răspunsurilor API

API utilizat:
https://reqres.in/

# Tehnologii utilizate

- Java 11
- Maven
- RestAssured
- TestNG
- IntelliJ IDEA

## Configurare proiect

- Clonare proiect: git clone <repository-url>
- Instalare dependente Maven: mvn clean install
- Configurare API: Pentru rularea testelor este necesar un API Key valid generat din platforma ReqRes https://app.reqres.in/api-keys. API key-ul este configurat în clasa BaseTest.java 

## Clase folosite

- BaseTest.java - Conține: configurarea Base URI, configurarea Request Specification, header-ul pentru autentificare (x-api-key)
- LoginTests.java - Conține teste pentru: login cu date valide, login fără parolă
- UserTests.java - Conține teste pentru: obținere listă utilizatori, creare utilizator, actualizare utilizator, ștergere utilizator, validare utilizator specific

## Exemple de validări efectuate

- validare status code
- validare response body
- validare existență token
- validare câmpuri JSON
- validare mesaje de eroare

## Rulare teste

- Rulare din IntelliJ IDEA: Click dreapta pe clasă + Run 'Tests'
- Rulare din terminal: mvn test

# Allure Reports

Proiectul utilizează Allure Reports pentru generarea rapoartelor automate de execuție ale testelor API.

Allure oferă:
- status teste (Passed / Failed)
- descriere scenarii
- severitate teste
- timp execuție
- organizare pe Features și Stories
- raport vizual interactiv

# Configurare, rulare si generare Allure

- Dependințe Maven - În fișierul `pom.xml` au fost adăugate dependințe
- Rulare teste: mvn clean test iar dupa executie se genereaza folderul allure-results
- Pentru deschiderea raportului: allure serve allure-results

# Annotations utilizate

În cadrul testelor au fost utilizate următoarele annotations Allure:

| Annotation | Rol |
|---|---|
| `@Epic` | categorie principală |
| `@Feature` | funcționalitate |
| `@Story` | scenariu testat |
| `@Description` | descriere test |
| `@Severity` | nivel importanță |
| `@Owner` | autor test |