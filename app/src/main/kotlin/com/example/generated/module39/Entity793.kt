package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_793")
data class Entity793(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity793Repository : org.springframework.data.jpa.repository.JpaRepository<Entity793, Long> {
    fun findByField1(field1: String): List<Entity793>
    fun findByField3GreaterThan(value: Int): List<Entity793>
}

@Service
@Transactional
class Service793(private val repo: Entity793Repository) {
    fun findAll(): List<Entity793> = repo.findAll()
    fun findByName(name: String): List<Entity793> = repo.findByField1(name)
    fun save(entity: Entity793): Entity793 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity793>): List<Entity793> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
