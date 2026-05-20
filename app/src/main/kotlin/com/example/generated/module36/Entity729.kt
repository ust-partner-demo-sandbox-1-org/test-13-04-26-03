package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_729")
data class Entity729(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity729Repository : org.springframework.data.jpa.repository.JpaRepository<Entity729, Long> {
    fun findByField1(field1: String): List<Entity729>
    fun findByField3GreaterThan(value: Int): List<Entity729>
}

@Service
@Transactional
class Service729(private val repo: Entity729Repository) {
    fun findAll(): List<Entity729> = repo.findAll()
    fun findByName(name: String): List<Entity729> = repo.findByField1(name)
    fun save(entity: Entity729): Entity729 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity729>): List<Entity729> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
