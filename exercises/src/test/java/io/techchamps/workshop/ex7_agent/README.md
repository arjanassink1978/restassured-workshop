# Exercise 7 - let the agent write the tests

Target: the `/api/profile` endpoints (GET, PUT, DELETE). No client and no test exist yet.

1. Start Claude Code in this module:  `cd exercises && claude`
2. Ask the agent (see .claude/agents/api-tester.md) to write `ProfileTest` in package `ex7_agent`.
   Your skill should make it create a `ProfileClient` first.
3. Review the result against your skill's rules: client used? DTOs and builders? AssertJ? Unique data and cleanup? 200/401/403?
4. Run it twice. Improve your skill where the agent got it wrong, and run the agent again.

## Bonus: does your test catch a bug?
Stop the backend and start it with a deliberate bug: users may now delete profiles.

    cd restbackend
    mvn spring-boot:run -Dspring-boot.run.arguments=--workshop.bug.profile-delete-open=true

Run your test again. If it stays green, your test does not check the access rules well enough.
Ask the agent to fix it, or improve the skill so it does this next time. Restart the backend without the flag afterwards.

Compare with the reference result in `solutions/.../ex7_agent/ProfileTest.java`.
