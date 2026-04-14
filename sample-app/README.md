# Sample App - CodeQL Test

Test application to reproduce and solve CodeQL private maven registry issues.

## Purpose

This project mimics the staircase-backend setup with:
- Private GitHub maven registry dependency
- Same Kotlin/Gradle versions (Kotlin 2.3.20, Java 21)
- CodeQL scanning configuration

## Building Locally

Create `.env` file:
```bash
GPR_USERNAME=your_github_username
GPR_PASSWORD=your_github_token
```

Build:
```bash
./gradlew build
```

Run:
```bash
./gradlew run
```

## CodeQL Test Scenarios

### Scenario 1: Default CodeQL (Expected to Fail)
- Enable CodeQL via GitHub UI default setup
- Should fail with 401 Unauthorized accessing private registry
- Matches staircase-backend error

### Scenario 2: Add Credentials via GitHub Settings
- Add GPR_USERNAME and GPR_PASSWORD as repository secrets
- Test if default CodeQL can access them

### Scenario 3: Custom CodeQL Workflow
- Create custom `.github/workflows/codeql.yml`
- Pass credentials in autobuild step
- Test if this resolves the issue
