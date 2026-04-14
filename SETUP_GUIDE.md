# CodeQL Test Project - Step-by-Step Guide

## Overview
This project replicates the staircase-backend CodeQL issue where private GitHub maven registry causes build failures.

**Structure:**
- `sample-library/` - Simple Kotlin library to publish as private package
- `sample-app/` - Main application depending on the private library

---

## STEP 1: Publish the Private Library

### 1.1 Create GitHub Personal Access Token (if you don't have one)

1. Go to GitHub → Settings → Developer settings → Personal access tokens → Tokens (classic)
2. Click "Generate new token (classic)"
3. Set scopes:
   - ✅ `write:packages` (includes read:packages)
   - ✅ `repo` (if repository is private)
4. Generate and **save** the token

### 1.2 Set Environment Variables

```bash
export GPR_USERNAME=your_github_username
export GPR_PASSWORD=your_github_token_from_step_1.1
```

### 1.3 Test Build Locally

```bash
cd sample-library
./gradlew build
```

### 1.4 Publish to GitHub Packages

```bash
./gradlew publish
```

**Expected output:** Library published to `https://github.com/Gainsight_GE-POC/code-ql-test/packages`

### 1.5 Verify Publication

Go to: `https://github.com/orgs/Gainsight_GE-POC/packages?repo_name=code-ql-test`

You should see: `com.gainsight.sample-library` version `1.0.0`

---

## STEP 2: Setup Sample App Repository

### 2.1 Initialize Git Repository

```bash
cd /Users/msengupta/Dummy/code-ql-test
git init
git add .
git commit -m "Initial commit: CodeQL test project"
```

### 2.2 Create GitHub Repository

1. Go to: `https://github.com/Gainsight_GE-POC`
2. Click "New repository"
3. Name: `code-ql-test`
4. **Important:** Keep it private (to test private package access)
5. Don't initialize with README (we already have files)
6. Create repository

### 2.3 Push Code

```bash
git remote add origin https://github.com/Gainsight_GE-POC/code-ql-test.git
git branch -M main
git push -u origin main
```

### 2.4 Add Repository Secrets

Go to: `https://github.com/Gainsight_GE-POC/code-ql-test/settings/secrets/actions`

Add two secrets:
- **Name:** `GPR_USERNAME`, **Value:** your GitHub username
- **Name:** `GPR_PASSWORD`, **Value:** your GitHub token from Step 1.1

---

## STEP 3: Test Scenario 1 - Default CodeQL (EXPECTED FAIL)

### 3.1 Enable CodeQL via UI

1. Go to: `https://github.com/Gainsight_GE-POC/code-ql-test/settings/security_analysis`
2. Under "Code scanning" → Click "Set up" for CodeQL
3. Choose "Default" setup
4. Click "Enable CodeQL"

### 3.2 Trigger Analysis

Push a small change or wait for automatic scan:
```bash
cd sample-app
echo "# Test" >> README.md
git add README.md
git commit -m "Trigger CodeQL scan"
git push
```

### 3.3 Expected Result: ❌ FAILURE

**Expected Error (same as staircase-backend):**
```
Could not resolve com.gainsight:sample-library:1.0.0
Could not GET 'https://maven.pkg.github.com/...'
Received status code 401 from server: Unauthorized
```

**Why it fails:** Default CodeQL autobuild doesn't have access to GPR_USERNAME/GPR_PASSWORD environment variables.

---

## STEP 4: Test Scenario 2 - Manual Build Mode (ATTEMPT)

### 4.1 Change CodeQL to Manual Mode

1. Go to: `https://github.com/Gainsight_GE-POC/code-ql-test/settings/security_analysis`
2. CodeQL analysis → Click "..." → Edit
3. Change build mode to "Manual"
4. Save

### 4.2 Expected Result: ⚠️ LIKELY STILL FAILS

**Reason:** Even with manual mode, you need to specify build commands, and the UI doesn't provide a way to inject environment variables before the build.

---

## STEP 5: Test Scenario 3 - Advanced CodeQL Workflow ✅

### 5.1 Disable Default CodeQL

1. Go to: `https://github.com/Gainsight_GE-POC/code-ql-test/settings/security_analysis`
2. CodeQL analysis → Click "..." → Disable

### 5.2 Use Custom Workflow

The file `.github/workflows/codeql-advanced.yml` is already created with the fix.

**Key differences:**
- Creates `.env` file with credentials **before** autobuild
- Uses `co.uzzu.dotenv.gradle` plugin to read credentials
- CodeQL autobuild then succeeds because credentials are available

### 5.3 Commit and Push

```bash
cd /Users/msengupta/Dummy/code-ql-test
git add sample-app/.github/workflows/codeql-advanced.yml
git commit -m "Add advanced CodeQL workflow with credentials"
git push
```

### 5.4 Expected Result: ✅ SUCCESS

- CodeQL analysis completes successfully
- Private library is accessible during build
- Code scanning results uploaded

---

## STEP 6: Verify and Monitor

### 6.1 Check Actions Tab

Go to: `https://github.com/Gainsight_GE-POC/code-ql-test/actions`

- ✅ "Build & Test" workflow should succeed
- ✅ "CodeQL Advanced" workflow should succeed

### 6.2 Check Security Tab

Go to: `https://github.com/Gainsight_GE-POC/code-ql-test/security/code-scanning`

You should see CodeQL results (may be empty or have findings).

---

## Summary of Results

| Scenario | Method | Result | Reason |
|----------|--------|--------|--------|
| 1 | Default CodeQL UI | ❌ Fails | No access to credentials |
| 2 | Manual Build Mode | ❌ Fails | Can't inject env vars via UI |
| 3 | Advanced Workflow | ✅ Works | Credentials provided before autobuild |

---

## Solution for Staircase-Backend

Apply the same approach to staircase-backend:

1. **Disable default CodeQL** in GitHub UI
2. **Create** `.github/workflows/codeql.yml` with:
   - Setup JDK
   - Create `.env` file with `GPR_USERNAME` and `GPR_PASSWORD` from secrets
   - Initialize CodeQL
   - Autobuild (will now succeed)
   - Analyze

3. **Reference workflow:** Use `sample-app/.github/workflows/codeql-advanced.yml` as template

---

## Troubleshooting

### Library Not Found After Publishing
- Verify package visibility in GitHub Packages
- Check package name matches: `com.gainsight:sample-library:1.0.0`
- Ensure token has `read:packages` scope

### 401 Unauthorized in Sample-App Build
- Verify repository secrets are set correctly
- Check `.env` file is created in workflow
- Confirm `co.uzzu.dotenv.gradle` plugin is in build.gradle.kts

### CodeQL Still Failing
- Check workflow runs in Actions tab for detailed logs
- Verify JDK version matches (21)
- Ensure Gradle wrapper files are committed
