---
name: restassured-workshop
description: Conventions for writing REST-Assured API tests in this repo (API clients, request specs, generated DTOs, builders, test data cleanup, role checks). Use whenever you create or change a REST-Assured test for the restbackend API.
---

# REST-Assured test conventions

Follow these rules for every new test. They are the result of the workshop exercises 1-7.

## Where things live
- Tests: `src/test/java/io/techchamps/workshop/<feature>/<Name>Test.java`
- Clients (one per resource, they know paths and specs): `io.techchamps.workshop.client.*`, e.g. `UserClient`, `AuthClient`
- Request specs: `io.techchamps.workshop.spec.RequestSpecs`; tokens: `io.techchamps.workshop.auth.TokenProvider`
- Builders (one per request DTO, valid and unique by default, `withX()` overrides): `io.techchamps.workshop.builders.*`
- DTOs: `generated.dtos.*`, generated from `restbackend/target/openapi.yaml`. NEVER hand-write a DTO.
- Config (baseUri, port, credentials): `config.properties` via `ConfigProperties`

## Rules
1. **A test never calls `given()` itself.** Every call goes through a client method. Missing endpoint? Add a method to the client for that resource, or create `<Resource>Client` following `UserClient`.
2. **Choose the caller explicitly:** `asAdmin()`, `asUser()`, `anonymous()` or `as(username, password)`. Never handle tokens in a test.
3. **No hardcoded URL, port, base path or credentials** anywhere except `config.properties`.
4. **DTOs instead of JSON strings.** Send DTOs built with a builder, read responses with `.extract().as(SomeResponse.class)`. Create a builder if one is missing.
5. **Assert in two steps:** REST-Assured for the status code (`.then().statusCode(..)`), AssertJ for the content of the DTO. No Hamcrest.
6. **Repeatable tests.** Builders generate unique usernames and emails. A test must pass twice in a row against the same running backend.
7. **Clean up what you create.** Track created usernames and delete them in an `@AfterEach` with `UserClient.asAdmin().deleteByUsername(..)`, also when an assertion fails.
8. **Test flows, not only endpoints.** If a user goal needs several calls (sign up, read, delete), do it in one test and pass values between calls.
9. **Cover the access rules.** For every endpoint with `@PreAuthorize`, test: allowed role (2xx), forbidden role (403), no token (401).
10. One behaviour per test, test names describe the behaviour (`userCannotDeleteProfile`). English only. Comment the why, not the what.

## Workflow
1. Read the endpoint in `restbackend/target/openapi.yaml` and its controller to learn status codes and roles.
2. Look at existing clients, builders and tests; reuse before creating.
3. Write the tests (and the client or builder if missing).
4. Run them: backend must be running on port 8085, then `mvn -pl <module> test -Dtest=<Name>Test`. Run twice.
5. Fix failures in the **test** unless the backend clearly violates its own OpenAPI contract; then report it, do not change the backend.

## Known API quirks (do not "fix" in tests)
- `roles` in user responses are strings like `Role{id=1, name=USER}`; sign-in returns `ROLE_USER`.
- Sign-up with a taken username returns 400 with `status: 404` in the body.
- Spring's own 401/403/400 errors have no `message` field, only `status` and `error`.
