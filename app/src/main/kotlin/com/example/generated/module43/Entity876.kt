package com.example.generated.module43

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_876")
data class Entity876(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity876Repository : org.springframework.data.jpa.repository.JpaRepository<Entity876, Long> {
    fun findByField1(field1: String): List<Entity876>
    fun findByField3GreaterThan(value: Int): List<Entity876>
}

@Service
@Transactional
class Service876(private val repo: Entity876Repository) {
    fun findAll(): List<Entity876> = repo.findAll()
    fun findByName(name: String): List<Entity876> = repo.findByField1(name)
    fun save(entity: Entity876): Entity876 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity876>): List<Entity876> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
