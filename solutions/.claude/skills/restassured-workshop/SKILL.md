---
name: restassured-workshop
description: Conventions for writing REST-Assured API tests in this repo (Helper specs, generated DTOs, builders, request chaining, repeatable data). Use whenever you create or change a REST-Assured test for the restbackend API.
---

# REST-Assured test conventions

Follow these rules for every new test. They are the result of the workshop exercises 1-5.

## Where things live
- Tests: `src/test/java/io/techchamps/workshop/<feature>/<Name>Test.java`
- Helper (specs + token handling): `io.techchamps.workshop.Helper`
- Builders: `io.techchamps.workshop.builders.*` (one per request DTO, sensible defaults, `withX()` overrides)
- DTOs: `generated.dtos.*` are generated from `restbackend/target/openapi.yaml`. NEVER hand-write a DTO.
- Config (baseUri, port, credentials): `config.properties` via `ConfigProperties`

## Rules
1. **No duplicated setup.** Start every request with `.spec(Helper.requestSpec())`, or `Helper.adminSpec()` / `Helper.userSpec()` / `Helper.authenticatedSpec(token)` when the endpoint needs a JWT.
2. **No hardcoded URL, port, base path or credentials** in a test. Use `Helper` and `config.properties`.
3. **DTOs instead of JSON strings.** Send `.body(dto)`, read `.extract().as(SomeResponse.class)`. Create a builder if one is missing.
4. **Repeatable tests.** Test data that must be unique (usernames, emails) gets a random suffix in the builder. A test must pass twice in a row against the same running backend.
5. **Test flows, not only endpoints.** If a user goal needs several calls (sign up -> read -> delete), do it in one test and pass values between calls with `.extract().path(..)` / `.as(..)`.
6. **Assert more than the status code.** Check the body fields that matter. Use AssertJ for DTO assertions, Hamcrest matchers inside `.body(..)`.
7. **Cover the access rules.** For every endpoint with `@PreAuthorize`, add tests for: allowed role (2xx), forbidden role (403), no token (401).
8. **Given / When / Then layout**, one behaviour per test, test method names describe the behaviour (`userCannotDeleteProfile`).
9. English only for names and comments. Comment the why, not the what.

## Workflow
1. Read the endpoint in `restbackend/target/openapi.yaml` and its controller to learn status codes and roles.
2. Look at existing tests and builders; reuse before creating.
3. Write the tests.
4. Run them: backend must be running on port 8085, then `mvn -pl <module> test -Dtest=<Name>Test`.
5. Fix failures in the **test** unless the backend clearly violates its own OpenAPI contract; in that case report it, do not change the backend.

## Known API quirks (do not "fix" in tests)
- `roles` in user responses are strings like `Role{id=1, name=USER}`; sign-in returns `ROLE_USER`.
- Sign-up with a taken username returns 400 with `status: 404` in the body.
- Spring's own 401/403/400 errors have no `message` field, only `status` and `error`.
