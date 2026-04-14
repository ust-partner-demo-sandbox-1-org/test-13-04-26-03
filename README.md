# CodeQL Test Project TESTing

Test environment to reproduce and solve CodeQL private maven registry authentication issues.

## 🎯 Purpose
Replicate staircase-backend's CodeQL failure where private GitHub Packages require credentials that default CodeQL setup cannot access.

## 📁 Structure
- **sample-library/** - Kotlin library to publish as private GitHub Package
- **sample-app/** - Application depending on the private library
- **SETUP_GUIDE.md** - Complete step-by-step testing instructions
- **QUICK_REFERENCE.md** - Solution summary
- **SOLUTION_FOR_STAIRCASE_BACKEND.yml** - Ready workflow for staircase-backend

## 🚀 Quick Start

### 1. Publish Private Library
```bash
cd sample-library
export GPR_USERNAME=your_github_username
export GPR_PASSWORD=your_github_token
./gradlew publish
```

### 2. Setup Repository
```bash
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/Gainsight_GE-POC/code-ql-test.git
git push -u origin main
```

### 3. Add Secrets
In GitHub repo settings, add:
- `GPR_USERNAME`
- `GPR_PASSWORD`

### 4. Test Three Scenarios
1. **Default CodeQL** → Should fail (401)
2. **Manual Build Mode** → Should fail
3. **Advanced Workflow** → Should succeed ✅

## 📖 Documentation
- See [SETUP_GUIDE.md](SETUP_GUIDE.md) for detailed instructions
- See [QUICK_REFERENCE.md](QUICK_REFERENCE.md) for solution summary

## 🔧 Technical Details
- **Language:** Kotlin 2.3.20
- **Java:** 21 (Temurin)
- **Build Tool:** Gradle 8.x
- **Pattern:** Matches staircase-backend configuration

## ✅ Expected Outcomes
| Scenario | Result | Reason |
|----------|--------|--------|
| Default CodeQL | ❌ Fails | No credential access |
| Manual Mode | ❌ Fails | Can't inject env vars |
| Advanced Workflow | ✅ Works | Credentials provided before build |

## 🎓 Key Learning
**Solution:** Create `.env` file with credentials **before** CodeQL autobuild step in a custom workflow.
