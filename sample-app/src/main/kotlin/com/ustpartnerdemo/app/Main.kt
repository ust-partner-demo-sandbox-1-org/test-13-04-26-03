package com.ustpartnerdemo.app

import com.ustpartnerdemo.library.PrivateUtils
import java.sql.DriverManager

/**
 * Main application that uses the private library
 * This simulates the staircase-backend scenario with vulnerable code
 */
fun main(args: Array<String>) {
    println("=== CodeQL Test Application ===")
    println(PrivateUtils.greet("CodeQL Tester"))
    println("2 + 3 = ${PrivateUtils.add(2, 3)}")
    println("Successfully accessed private library!")
    
    // Demonstrate vulnerabilities with user input from command line args
    if (args.isNotEmpty()) {
        val userInput = args[0]
        println("\n=== Testing with user input: $userInput ===")
        
        // SQL Injection vulnerability - user input flows to SQL query
        try {
            val connection = DriverManager.getConnection(
                "jdbc:h2:mem:test",
                "sa",
                ""
            )
            // Create a test table
            connection.createStatement().execute("CREATE TABLE IF NOT EXISTS users (id VARCHAR(50), username VARCHAR(100), email VARCHAR(100))")
            connection.createStatement().execute("INSERT INTO users VALUES ('1', 'admin', 'admin@example.com')")
            
            val vulnerableResult = VulnerableCode.getUserData(userInput, connection)
            println("User data: $vulnerableResult")
            
            // SQL injection via email search
            val emailResult = VulnerableCode.findUserByEmail(userInput, connection)
            println("Email search: $emailResult")
            
            connection.close()
        } catch (e: Exception) {
            println("Database error: ${e.message}")
        }
        
        // Command injection - user input in system command
        try {
            val commandResult = VulnerableCode.executeSystemCommand(userInput)
            println("Command output: $commandResult")
        } catch (e: Exception) {
            println("Command error: ${e.message}")
        }
        
        // Path traversal - user input in file path
        try {
            val fileContent = VulnerableCode.readUserFile(userInput)
            println("File content: $fileContent")
        } catch (e: Exception) {
            println("File error: ${e.message}")
        }
        
        // XXE vulnerability
        try {
            val xmlResult = VulnerableCode.parseXml(userInput)
            println("XML parsed: $xmlResult")
        } catch (e: Exception) {
            println("XML error: ${e.message}")
        }
        
        // XSS vulnerability
        val htmlResponse = VulnerableCode.generateHtmlResponse(userInput)
        println("HTML response generated: ${htmlResponse.length} bytes")
        
        // Login with cleartext logging
        VulnerableCode.loginUser("testuser", userInput)
        
        // Insecure token generation
        println("Security token: ${VulnerableCode.generateSecurityToken()}")
        
        // Weak crypto
        println("MD5 hash: ${VulnerableCode.encryptData(userInput)}")

        // Unsafe deserialization - user input converted to bytes and deserialized
        try {
            val deserializedObj = VulnerableCode.deserializeData(userInput.toByteArray())
            println("Deserialized: $deserializedObj")
        } catch (e: Exception) {
            println("Deserialization error: ${e.message}")
        }

        // LDAP injection - user input flows directly into LDAP filter
        try {
            val ldapResult = VulnerableCode.searchLdap(userInput)
            println("LDAP result: $ldapResult")
        } catch (e: Exception) {
            println("LDAP error: ${e.message}")
        }

        // SSRF - user input used as URL for outbound HTTP request
        try {
            val remoteContent = VulnerableCode.fetchRemoteResource(userInput)
            println("Remote content length: ${remoteContent.length}")
        } catch (e: Exception) {
            println("SSRF error: ${e.message}")
        }

        // SQL injection via ORDER BY clause
        try {
            val connection = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "")
            connection.createStatement().execute("CREATE TABLE IF NOT EXISTS products (name VARCHAR(100))")
            val products = VulnerableCode.getProductsSortedBy(userInput, connection)
            println("Products: $products")
            connection.close()
        } catch (e: Exception) {
            println("OrderBy SQL error: ${e.message}")
        }

        // XSS via error page
        val errorPage = VulnerableCode.renderErrorPage(userInput)
        println("Error page generated: ${errorPage.length} bytes")
    }
}
