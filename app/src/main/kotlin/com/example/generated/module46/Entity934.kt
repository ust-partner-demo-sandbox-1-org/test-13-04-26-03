package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_934")
data class Entity934(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity934Repository : org.springframework.data.jpa.repository.JpaRepository<Entity934, Long> {
    fun findByField1(field1: String): List<Entity934>
    fun findByField3GreaterThan(value: Int): List<Entity934>
}

@Service
@Transactional
class Service934(private val repo: Entity934Repository) {
    fun findAll(): List<Entity934> = repo.findAll()
    fun findByName(name: String): List<Entity934> = repo.findByField1(name)
    fun save(entity: Entity934): Entity934 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity934>): List<Entity934> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
