package com.ustpartnerdemo.library

/**
 * Simple utility class for testing private maven registry access
 */
object PrivateUtils {
    
    fun greet(name: String): String {
        return "Hello from private library, $name!"
    }
    
    fun add(a: Int, b: Int): Int {
        return a + b
    }
}
