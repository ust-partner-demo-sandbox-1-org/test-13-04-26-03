package com.ustpartnerdemo.app

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement
import java.io.ObjectInputStream
import java.io.ByteArrayInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.naming.directory.InitialDirContext
import javax.naming.directory.SearchControls
import java.util.Random
import org.slf4j.LoggerFactory

/**
 * Intentionally vulnerable code to test CodeQL detection
 * Contains multiple security vulnerabilities that CodeQL should flag
 */
object VulnerableCode {
    private val logger = LoggerFactory.getLogger(VulnerableCode::class.java)
    
    // SQL Injection vulnerability
    fun getUserData(userId: String, connection: Connection): String {
        val statement: Statement = connection.createStatement()
        // Vulnerable: Direct string concatenation in SQL query
        val query = "SELECT * FROM users WHERE id = '" + userId + "'"
        val resultSet = statement.executeQuery(query)
        
        return if (resultSet.next()) {
            resultSet.getString("username")
        } else {
            "User not found"
        }
    }
    
    // Hardcoded credentials vulnerability
    fun connectToDatabase(): Connection {
        val jdbcUrl = "jdbc:postgresql://localhost:5432/mydb"
        val username = "admin"
        val password = "SuperSecret123!" // Hardcoded password - security issue
        
        return DriverManager.getConnection(jdbcUrl, username, password)
    }
    
    // Command injection vulnerability
    fun executeSystemCommand(userInput: String): String {
        // Vulnerable: User input directly in system command
        val process = Runtime.getRuntime().exec("ls -la $userInput")
        return process.inputStream.bufferedReader().use { it.readText() }
    }
    
    // Path traversal vulnerability
    fun readUserFile(filename: String): String {
        // Vulnerable: No sanitization of user-provided filename
        val file = java.io.File("/var/data/$filename")
        return file.readText()
    }
    
    // XXE (XML External Entity) vulnerability
    fun parseXml(xmlContent: String): String {
        // Vulnerable: XXE attack possible - no protection against external entities
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        val doc = builder.parse(ByteArrayInputStream(xmlContent.toByteArray()))
        return doc.documentElement.nodeName
    }
    
    // Unsafe deserialization vulnerability
    fun deserializeData(serializedData: ByteArray): Any {
        // Vulnerable: Deserializing untrusted data can lead to remote code execution
        val ois = ObjectInputStream(ByteArrayInputStream(serializedData))
        return ois.readObject()
    }
    
    // LDAP injection vulnerability
    fun searchLdap(username: String): String {
        // Vulnerable: User input directly in LDAP filter
        val env = java.util.Hashtable<String, String>()
        env["java.naming.factory.initial"] = "com.sun.jndi.ldap.LdapCtxFactory"
        env["java.naming.provider.url"] = "ldap://localhost:389"
        
        val ctx = InitialDirContext(env)
        val searchControls = SearchControls()
        val filter = "(uid=$username)" // Vulnerable to LDAP injection
        val results = ctx.search("ou=users,dc=example,dc=com", filter, searchControls)
        
        return if (results.hasMore()) {
            results.next().name
        } else {
            "Not found"
        }
    }
    
    // Cleartext logging of sensitive data
    fun loginUser(username: String, password: String): Boolean {
        // Vulnerable: Logging password in cleartext
        logger.info("User login attempt: username=$username, password=$password")
        return username == "admin" && password == "SuperSecret123!"
    }
    
    // Insecure randomness
    fun generateSecurityToken(): String {
        // Vulnerable: Using non-cryptographic Random for security token
        val random = Random()
        val bytes = ByteArray(16)
        random.nextBytes(bytes)
        return bytes.joinToString("") { "%02x".format(it) }
    }
    
    // XSS vulnerability (reflected)
    fun generateHtmlResponse(userInput: String): String {
        // Vulnerable: User input directly in HTML without sanitization
        return "<html><body><h1>Welcome $userInput</h1></body></html>"
    }
    
    // SQL injection via string formatting
    fun findUserByEmail(email: String, connection: Connection): String {
        // Vulnerable: Using string formatting instead of prepared statements
        val query = String.format("SELECT username FROM users WHERE email = '%s'", email)
        val statement = connection.createStatement()
        val resultSet = statement.executeQuery(query)
        
        return if (resultSet.next()) {
            resultSet.getString("username")
        } else {
            "Not found"
        }
    }
    
    // Trust boundary violation
    fun storeUserSession(userInput: String, session: javax.servlet.http.HttpSession) {
        // Vulnerable: Storing untrusted user input directly in session
        session.setAttribute("userData", userInput)
    }
    
    // Weak cryptography
    fun encryptData(data: String): String {
        // Vulnerable: Using MD5 which is cryptographically broken
        val md = java.security.MessageDigest.getInstance("MD5")
        val digest = md.digest(data.toByteArray())
        return digest.joinToString("") { "%02x".format(it) }
    }

    // SSRF (Server-Side Request Forgery) vulnerability - CWE-918
    fun fetchRemoteResource(userSuppliedUrl: String): String {
        // Vulnerable: User-controlled URL used in HTTP request without validation
        val url = java.net.URL(userSuppliedUrl)
        val connection = url.openConnection() as java.net.HttpURLConnection
        connection.requestMethod = "GET"
        return connection.inputStream.bufferedReader().use { it.readText() }
    }

    // SQL Injection via ORDER BY clause - CWE-89
    fun getProductsSortedBy(sortColumn: String, connection: Connection): List<String> {
        // Vulnerable: sort column injected directly, cannot use prepared statement for ORDER BY
        val query = "SELECT name FROM products ORDER BY $sortColumn"
        val resultSet = connection.createStatement().executeQuery(query)
        val results = mutableListOf<String>()
        while (resultSet.next()) results.add(resultSet.getString("name"))
        return results
    }

    // XSS via error page - CWE-79
    fun renderErrorPage(errorMessage: String): String {
        // Vulnerable: user-controlled error message injected into HTML without encoding
        return """
            <html>
              <body>
                <h2>Error</h2>
                <p class="error-detail">$errorMessage</p>
              </body>
            </html>
        """.trimIndent()
    }
}
