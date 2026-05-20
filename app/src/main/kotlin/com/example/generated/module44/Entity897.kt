package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_897")
data class Entity897(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity897Repository : org.springframework.data.jpa.repository.JpaRepository<Entity897, Long> {
    fun findByField1(field1: String): List<Entity897>
    fun findByField3GreaterThan(value: Int): List<Entity897>
}

@Service
@Transactional
class Service897(private val repo: Entity897Repository) {
    fun findAll(): List<Entity897> = repo.findAll()
    fun findByName(name: String): List<Entity897> = repo.findByField1(name)
    fun save(entity: Entity897): Entity897 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity897>): List<Entity897> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
