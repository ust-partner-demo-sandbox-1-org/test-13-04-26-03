package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_786")
data class Entity786(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity786Repository : org.springframework.data.jpa.repository.JpaRepository<Entity786, Long> {
    fun findByField1(field1: String): List<Entity786>
    fun findByField3GreaterThan(value: Int): List<Entity786>
}

@Service
@Transactional
class Service786(private val repo: Entity786Repository) {
    fun findAll(): List<Entity786> = repo.findAll()
    fun findByName(name: String): List<Entity786> = repo.findByField1(name)
    fun save(entity: Entity786): Entity786 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity786>): List<Entity786> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
