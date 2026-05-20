package com.example.generated.module28

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_573")
data class Entity573(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity573Repository : org.springframework.data.jpa.repository.JpaRepository<Entity573, Long> {
    fun findByField1(field1: String): List<Entity573>
    fun findByField3GreaterThan(value: Int): List<Entity573>
}

@Service
@Transactional
class Service573(private val repo: Entity573Repository) {
    fun findAll(): List<Entity573> = repo.findAll()
    fun findByName(name: String): List<Entity573> = repo.findByField1(name)
    fun save(entity: Entity573): Entity573 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity573>): List<Entity573> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
