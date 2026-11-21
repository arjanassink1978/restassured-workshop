# Conference submission: From zero to API hero

Draft text for a call for proposals. Items in `[brackets]` need your input.

---

## English

### Title
**From zero to API hero: write API tests you can hand to an AI agent**

### Short description (for the programme, about 40 words)
Learn how to build maintainable REST-Assured tests with clients, DTOs and builders. Then turn what you learned into rules that an AI coding assistant can follow, and find out whether the tests it writes actually catch a bug.

### Abstract
AI assistants write API tests in seconds, but without your conventions they produce code that works once and fits no project: hardcoded URLs and tokens, duplicated setup and a single status-code check. To instruct an agent well, you first have to know what good looks like.

In this hands-on workshop you build that knowledge step by step on a real Spring Boot API. You start with a verbose first test, then introduce an API client with a shared request specification, generated DTOs, role-based authentication, request chaining, builders with unique test data and cleanup. Every step solves a pain you just felt.

In the last part you write down the rules you learned as an `AGENTS.md` and a `SKILL.md`, let an AI assistant create tests for an endpoint nobody tested yet, review the result and improve your instructions, not the output. As a bonus we switch on a deliberate bug in the backend: does your test turn red? Green tests prove very little, a test that fails when it should proves a lot.

The workshop is tool-independent. Any AI coding assistant that reads `AGENTS.md` and skills works. You leave with a complete repository, a working skill and a checklist for reviewing AI-written tests.

### Learning objectives
After this workshop you can:
1. Structure REST-Assured tests with API clients, request specifications, generated DTOs and builders instead of repeated `given()` chains.
2. Test authentication and authorisation (200, 401 and 403) and whole flows with request chaining, with repeatable data and cleanup.
3. Translate your own test conventions into concrete, checkable instructions for an AI coding assistant.
4. Review AI-written tests critically and check that they catch a real bug.

### Audience and prerequisites
- For testers and developers who write or want to write API tests. Level: beginner to intermediate in API testing.
- Some Java is needed (reading and writing simple classes). No REST-Assured or AI-tool experience required.
- Maximum group size: `[for example 20 to 30]`.

### What participants bring
A laptop with Java 21 or higher, Maven, Git and an AI coding assistant that can read a repository and run commands (for example Claude Code, GitHub Copilot, Codex, Gemini CLI or Cursor). Setup is a prerequisite: attendees who cannot get it working follow along with a neighbour. Instructions are sent before the workshop.

### What participants take home
- A repository with exercises, reference solutions and the backend.
- A working `AGENTS.md` and skill for API tests.
- A checklist for reviewing AI-written tests.

### Format and timing
Four hours, about two thirds hands-on.

| Block | Content |
|---|---|
| Check, theory, Swagger | REST basics, status codes, try the API by hand (20 min) |
| Exercises 1 to 3 | First test, API client and DTOs, authentication and roles |
| Exercises 4 and 5 | Request chaining and cleanup, builders and test data |
| AI part | Theory and demo, write your rules (exercise 6), let the assistant write tests and catch a bug (exercise 7) |
| Wrap-up | What changes in a real project |

### Why this workshop
- It starts from understanding, not from the tool: you cannot instruct an agent about something you do not understand.
- It is tool-independent and based on open conventions (`AGENTS.md`, `SKILL.md`).
- It tests the AI-written tests with a deliberate bug.
- It builds on a tutorial that has been given at an international testing conference.

### Speaker
Arjan Assink works in Enschede and has more than 10 years of experience in test automation. He works at TechChamps. He gave a tutorial on REST-Assured at the testing conference in Athens `[add conference name and year]`, which this workshop builds on and extends with AI assistants. `[Add: other talks, communities.]`

---

## Nederlands

### Titel
**From zero to API hero: schrijf API-tests die je aan een AI-agent kunt overdragen**

### Korte omschrijving (voor het programma, ongeveer 40 woorden)
Leer onderhoudbare REST-Assured-tests bouwen met clients, DTO's en builders. Zet daarna wat je leerde om in regels die een AI-assistent kan volgen, en ontdek of de tests die hij schrijft ook echt een bug vangen.

### Abstract
AI-assistenten schrijven API-tests in seconden, maar zonder jouw afspraken maken ze code die één keer werkt en nergens in past: hardcoded URL's en tokens, dubbele setup en één statuscode-check. Om een agent goed te instrueren, moet je eerst weten hoe goed eruitziet.

In deze hands-on workshop bouw je die kennis stap voor stap op een echte Spring Boot-API. Je begint met een uitgebreide eerste test, en voert dan een API-client met een gedeelde request-specificatie in, gegenereerde DTO's, rolgebaseerde authenticatie, request chaining, builders met unieke testdata en opruimen. Elke stap lost een pijn op die je net voelde.

In het laatste deel schrijf je de geleerde regels op als `AGENTS.md` en `SKILL.md`. Je laat een AI-assistent tests maken voor een endpoint dat nog niemand testte, beoordeelt het resultaat en verbetert je instructies, niet de uitvoer. Als bonus zetten we een bewuste bug in de backend aan: wordt jouw test rood? Groene tests bewijzen weinig, een test die faalt als het moet bewijst veel.

De workshop is tool-onafhankelijk. Elke AI-codeerassistent die `AGENTS.md` en skills leest werkt. Je gaat naar huis met een complete repository, een werkende skill en een checklist voor het beoordelen van door AI geschreven tests.

### Leerdoelen
Na deze workshop kun je:
1. REST-Assured-tests structureren met API-clients, request-specificaties, gegenereerde DTO's en builders in plaats van herhaalde `given()`-ketens.
2. Authenticatie en autorisatie testen (200, 401 en 403) en complete flows met request chaining, met herhaalbare data en opruimen.
3. Je eigen testafspraken vertalen naar concrete, controleerbare instructies voor een AI-codeerassistent.
4. Door AI geschreven tests kritisch beoordelen en controleren dat ze een echte bug vangen.

### Doelgroep en voorkennis
- Voor testers en ontwikkelaars die API-tests schrijven of willen schrijven. Niveau: beginner tot gemiddeld in API-testen.
- Wat Java is nodig (eenvoudige klassen lezen en schrijven). Ervaring met REST-Assured of AI-tools is niet nodig.
- Maximale groepsgrootte: `[bijvoorbeeld 20 tot 30]`.

### Wat deelnemers meenemen
Een laptop met Java 21 of hoger, Maven, Git en een AI-codeerassistent die een repository kan lezen en commando's kan uitvoeren (bijvoorbeeld Claude Code, GitHub Copilot, Codex, Gemini CLI of Cursor). De installatie is een voorwaarde: wie het niet werkend krijgt, kijkt mee bij een buur. Instructies volgen vooraf.

### Wat deelnemers mee naar huis nemen
- Een repository met oefeningen, voorbeelduitwerkingen en de backend.
- Een werkende `AGENTS.md` en skill voor API-tests.
- Een checklist voor het beoordelen van door AI geschreven tests.

### Opzet en tijdsindeling
Vier uur, ongeveer twee derde hands-on. Zie de Engelse tabel hierboven.

### Waarom deze workshop
- Hij begint bij begrip, niet bij de tool: je kunt een agent niet instrueren over iets wat je zelf niet snapt.
- Hij is tool-onafhankelijk en gebaseerd op open afspraken (`AGENTS.md`, `SKILL.md`).
- Hij test de door AI geschreven tests met een bewuste bug.
- Hij bouwt voort op een tutorial die al op een internationale testconferentie is gegeven.

### Spreker
Arjan Assink werkt in Enschede en heeft meer dan 10 jaar ervaring met testautomatisering. Hij werkt bij TechChamps. Hij gaf een tutorial over REST-Assured op de testconferentie in Athene `[naam en jaar aanvullen]`, waarop deze workshop voortbouwt en die hij uitbreidt met AI-assistenten. `[Aanvullen: andere talks, communities.]`

---

## Before you submit

- [ ] If possible, run through the exercises with one or two colleagues first and adjust the timing.
- [ ] Walk through the whole slide deck and check every slide visually.
- [ ] Try the pre-work on a clean laptop with the AI tool you will name. Check the file locations for each tool you mention against its own documentation.
- [ ] Make the repository public if the call asks for materials.
- [ ] Check the conference rules: duration, group size, language, wifi, whether a vendor tool is allowed.
- [ ] Adapt the timing if the slot is shorter than four hours.
