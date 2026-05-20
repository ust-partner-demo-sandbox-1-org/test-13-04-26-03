package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_277")
data class Entity277(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity277Repository : org.springframework.data.jpa.repository.JpaRepository<Entity277, Long> {
    fun findByField1(field1: String): List<Entity277>
    fun findByField3GreaterThan(value: Int): List<Entity277>
}

@Service
@Transactional
class Service277(private val repo: Entity277Repository) {
    fun findAll(): List<Entity277> = repo.findAll()
    fun findByName(name: String): List<Entity277> = repo.findByField1(name)
    fun save(entity: Entity277): Entity277 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity277>): List<Entity277> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
