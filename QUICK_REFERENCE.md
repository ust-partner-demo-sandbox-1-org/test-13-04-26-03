# CodeQL Private Registry Fix - Quick Reference

## Problem
CodeQL default setup fails with:
```
401 Unauthorized accessing https://maven.pkg.github.com/...
```

## Root Cause
- CodeQL autobuild runs independently
- No access to `GPR_USERNAME` and `GPR_PASSWORD` credentials
- Private maven registry requires authentication

## Solution
Switch from **Default CodeQL** to **Advanced CodeQL workflow**

### Implementation Steps

1. **Disable Default CodeQL**
   - Go to repo Settings → Security → Code scanning
   - Disable CodeQL default setup

2. **Create `.github/workflows/codeql.yml`**
   ```yaml
   - name: Create .env file with credentials
     run: |
       touch .env
       echo GPR_USERNAME=${{ secrets.GPR_USERNAME }} >> .env
       echo GPR_PASSWORD=${{ secrets.GPR_PASSWORD }} >> .env
   
   - name: Initialize CodeQL
     uses: github/codeql-action/init@v3
   
   - name: Autobuild
     uses: github/codeql-action/autobuild@v3
   ```

3. **Ensure Secrets Exist**
   - Settings → Secrets and variables → Actions
   - Verify `GPR_USERNAME` and `GPR_PASSWORD` exist

4. **Key Point**
   - Create `.env` **BEFORE** CodeQL init/autobuild
   - Your `build.gradle.kts` uses `co.uzzu.dotenv.gradle` plugin to read credentials
   - Autobuild will have access to private registry

## Test Project
Location: `/Users/msengupta/Dummy/code-ql-test/`
- `sample-library/` - Private package to publish
- `sample-app/` - App depending on private package
- `SETUP_GUIDE.md` - Detailed testing instructions
- `SOLUTION_FOR_STAIRCASE_BACKEND.yml` - Ready-to-use workflow

## Verification
After applying fix:
- ✅ CodeQL workflow completes
- ✅ No 401 errors
- ✅ Code scanning results appear in Security tab
