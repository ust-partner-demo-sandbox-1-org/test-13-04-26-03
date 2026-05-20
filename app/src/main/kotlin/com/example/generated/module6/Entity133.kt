package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_133")
data class Entity133(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity133Repository : org.springframework.data.jpa.repository.JpaRepository<Entity133, Long> {
    fun findByField1(field1: String): List<Entity133>
    fun findByField3GreaterThan(value: Int): List<Entity133>
}

@Service
@Transactional
class Service133(private val repo: Entity133Repository) {
    fun findAll(): List<Entity133> = repo.findAll()
    fun findByName(name: String): List<Entity133> = repo.findByField1(name)
    fun save(entity: Entity133): Entity133 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity133>): List<Entity133> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
