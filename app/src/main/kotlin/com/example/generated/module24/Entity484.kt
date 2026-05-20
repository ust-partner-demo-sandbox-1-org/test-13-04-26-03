package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_484")
data class Entity484(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity484Repository : org.springframework.data.jpa.repository.JpaRepository<Entity484, Long> {
    fun findByField1(field1: String): List<Entity484>
    fun findByField3GreaterThan(value: Int): List<Entity484>
}

@Service
@Transactional
class Service484(private val repo: Entity484Repository) {
    fun findAll(): List<Entity484> = repo.findAll()
    fun findByName(name: String): List<Entity484> = repo.findByField1(name)
    fun save(entity: Entity484): Entity484 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity484>): List<Entity484> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
