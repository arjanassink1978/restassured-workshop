---
name: restassured-workshop
description: Conventions for writing REST-Assured API tests in this repo (API clients, request specs, generated DTOs, builders, test data cleanup, role checks). Use whenever you create or change a REST-Assured test for the restbackend API.
---

# REST-Assured test conventions

Follow these rules for every new test. (Description, locations and workflow are given: your job in exercise 8 is the rules.)

## Where things live
- Tests: `src/test/java/io/techchamps/workshop/<feature>/<Name>Test.java`
- Clients (one per resource, they know paths and specs): `io.techchamps.workshop.client.*`
- Request specs: `io.techchamps.workshop.spec.RequestSpecs`; tokens: `io.techchamps.workshop.auth.TokenProvider`
- Builders (one per request DTO): `io.techchamps.workshop.builders.*`
- DTOs: `generated.dtos.*`, generated from `restbackend/target/openapi.yaml`
- Config: `config.properties` via `ConfigProperties`

## Rules
TODO (exercise 8): at least 8 rules, short, concrete and checkable. Write for a new colleague who has never seen the repo.
Look back at each exercise and ask: what did I learn that an agent would get wrong?
- exercise 1: what do you check in a response?
- exercise 2: where do the URL, port and content type live?
- exercise 3: how are request bodies and responses represented?
- exercise 4: who talks to the API, and who does not?
- exercise 5: how does a test choose who calls, and what must every endpoint be tested for?
- exercise 6: flows, data that must be unique, what happens to data after the test
- exercise 7: how do you create valid, unique test data?
- assertions: which library for what?

## Workflow
1. Read the endpoint in `restbackend/target/openapi.yaml` and its controller to learn status codes and roles.
2. Look at existing clients, builders and tests; reuse before creating.
3. Write the tests (and the client or builder if missing).
4. Run them: backend must be running on port 8085, then `mvn -pl <module> test -Dtest=<Name>Test`. Run twice.
5. Fix failures in the test unless the backend clearly violates its own OpenAPI contract; then report it, do not change the backend.

## Known API quirks
TODO (optional): things in this API that look like bugs but are not your concern.
