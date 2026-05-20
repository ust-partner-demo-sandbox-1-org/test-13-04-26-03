package com.example.generated.module12

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_244")
data class Entity244(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity244Repository : org.springframework.data.jpa.repository.JpaRepository<Entity244, Long> {
    fun findByField1(field1: String): List<Entity244>
    fun findByField3GreaterThan(value: Int): List<Entity244>
}

@Service
@Transactional
class Service244(private val repo: Entity244Repository) {
    fun findAll(): List<Entity244> = repo.findAll()
    fun findByName(name: String): List<Entity244> = repo.findByField1(name)
    fun save(entity: Entity244): Entity244 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity244>): List<Entity244> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
