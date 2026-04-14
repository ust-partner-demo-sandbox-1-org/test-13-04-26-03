# Sample Library

A simple Kotlin library for testing GitHub Packages and CodeQL integration.

## Building

```bash
./gradlew build
```

## Publishing to GitHub Packages

Set environment variables and publish:

```bash
export GPR_USERNAME=your_github_username
export GPR_PASSWORD=your_github_token
./gradlew publish
```
