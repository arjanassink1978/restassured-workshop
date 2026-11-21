# TechChamps REST-Assured workshop (4 hours)

From zero to API hero with Java and REST-Assured, finishing with an AI agent + skill that writes tests in your structure.

## Repo layout
| Module | Purpose |
|---|---|
| `restbackend/` | Spring Boot API under test (port 8085, H2 in memory, JWT) |
| `exercises/` | **Your workspace.** Starter code with TODOs per exercise (`ex1_basics` ... `ex7_agent`) |
| `solutions/` | Reference solution per exercise, plus the finished `AGENTS.md` and skill (`.claude/skills/`) |

## Pre-work (required, before the workshop)
You must have this working when you arrive. Stuck? Sit next to a colleague and follow along: we do not debug installations during the workshop.
1. Clone the repo, install Java 21+, Maven and an AI coding assistant that can read your repo and run commands (for example Claude Code, GitHub Copilot, Codex, Gemini CLI or Cursor) and check that it works
2. `mvn clean install -DskipTests` succeeds
3. Backend starts (`cd restbackend && mvn spring-boot:run`) and http://localhost:8085/swagger-ui/index.html opens
4. `mvn -pl solutions test` is green (backend running)
5. Using IntelliJ? Open the repo root as a Maven project and set the project SDK to a JDK 21 or higher (File > Project Structure > Project). If it says "JDK missing", add one via SDKs > Add SDK > Add JDK.

## Workshop agenda
| Time | Block | Exercise |
|---|---|---|
| 0:00 | Check and intro | |
| 0:05 | APIs and REST-Assured basics | |
| 0:15 | Swagger: try the API yourself | hands-on |
| 0:20 | Your first test | Ex 1 `ex1_basics` (15 min) |
| 0:35 | DTOs, then an API client with a request spec | Ex 2 `ex2_client` (25 min) |
| 1:00 | Authentication (JWT) and roles | Ex 3 `ex3_auth` (20 min) |
| 1:20 | Break | |
| 1:30 | Request chaining and cleanup | Ex 4 `ex4_chaining` (20 min) |
| 1:50 | Builders and test data | Ex 5 `ex5_dto` (15 min) |
| 2:05 | Break | |
| 2:15 | From tests to agent + skill: theory and demo | |
| 2:35 | Write your own skill and agent | Ex 6 (30 min) |
| 3:05 | Let the agent write tests, improve the skill, bonus: catch a bug | Ex 7 `ex7_agent` (35 min) |
| 3:40 | Wrap-up and buffer | |

## Test structure used in this repo
```
spec/RequestSpecs      shared request specification (config, content type, logging only on failure)
auth/TokenProvider     signs in once per user, caches the JWT
client/*Client         one class per resource: knows paths and specs, tests never call given() themselves
builders/*             valid + unique request DTOs
generated.dtos.*       DTOs generated from the backend's OpenAPI spec
```
Tests check the status with REST-Assured and the content with AssertJ, and clean up their data in `@AfterEach`.


## How to work
- Do the exercises in `exercises/`. Run one class: `mvn -pl exercises test -Dtest=BasicLoginTest`
- Every `fail("TODO ...")` is red until you implement the test.
- Stuck? Peek in `solutions/`. Run the reference: `mvn -pl solutions test`
- Exercise 6 and 7 use an AI assistant: start it from inside the `exercises/` folder.
  - `AGENTS.md` holds the instructions (role, always, output, stop conditions). Claude Code reads it through `CLAUDE.md`, which imports it.
  - The skill is `.claude/skills/restassured-workshop/SKILL.md` (the open SKILL.md format). Other tools look in their own folder, for example GitHub Copilot in `.github/skills/`. Check your tool's documentation and copy the skill folder there if needed.

## Pre-requisites
- Install Git: https://git-scm.com
- Install Maven: https://maven.apache.org/download.cgi
- Install Java 21 (LTS) or higher, e.g. https://adoptium.net
- Versions used: Spring Boot 4.2.0, springdoc 3.2.1, REST-Assured 6.3.0, JUnit 6.1.3
- Install NodeJS: https://nodejs.org/en/download/, [Node Version Manager-linux/Mac](https://github.com/nvm-sh/nvm) or [Node Version Manager-Windows](https://github.com/coreybutler/nvm-windows)
- An AI coding assistant for the last part of the workshop (the exercises use Claude Code as example, any tool that reads `AGENTS.md` and `SKILL.md` works)
- Optional: install Docker: https://docs.docker.com/get-docker

## Installation
- open a terminal in the repo root (restassured-workshop)
- run from terminal `mvn clean install -DskipTests` (the build starts the backend briefly to generate `restbackend/target/openapi.yaml`, which is used to generate the DTOs)

## Start Back-end local

## Generate open-api.yaml file
- make sure the application is running
- run from terminal `mvn springdoc-openapi:generate`

### Backend:
  - in folder restbackend go to src/main/resources/java/Application.java
  - run application main class
  - Backend is running on http://localhost:8085
    - alternative: run from terminal 
    
    ```sh
    # Run the server (from the restbackend folder)
    mvn spring-boot:run
    ```

## Backend Swagger and Database console
You can use:
- swagger-url: http://localhost:8085/swagger-ui/index.html
- h2-console: http://localhost:8085/h2-console
  - login with username: sa and password: empty
  - jdbc:h2:mem:testdb

## H2-Database
- The H2 database is running in memory, so if you restart the backend then the database will go back to default state
- Default there are 3 user inside the database:
* admin, password admin1234, role admin and role user
* user, password user1234, role user
* moderator password moderator1234, role moderator
