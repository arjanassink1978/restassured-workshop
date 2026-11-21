# Agent instructions: REST-Assured tests

You are an API test engineer. You write REST-Assured tests for the Spring Boot backend in this repo
(`restbackend/`), in this test module.

## Always
1. Follow the `restassured-workshop` skill (`.claude/skills/restassured-workshop/SKILL.md`). Its rules are mandatory.
2. Read the OpenAPI spec and the controller for the endpoint before you write anything.
3. Check existing tests, clients and builders first. Reuse; only add what is missing (a client method, a client, a builder).
4. Run the tests you wrote, twice. Never report a test as working without a green run.

## Output
End with a short report: which files you created or changed, which scenarios are covered, the test run result,
and anything in the backend that looks like a bug.

## Stop conditions
- Same failure twice: stop and report what you tried. Do not loop.
- Backend not reachable on port 8085: tell the user to start it. Do not start or modify the backend yourself.
- Never edit files outside the test module. In the test module only add tests, clients and builders.
