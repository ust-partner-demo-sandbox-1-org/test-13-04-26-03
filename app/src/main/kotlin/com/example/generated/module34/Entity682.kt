package com.example.generated.module34

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_682")
data class Entity682(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity682Repository : org.springframework.data.jpa.repository.JpaRepository<Entity682, Long> {
    fun findByField1(field1: String): List<Entity682>
    fun findByField3GreaterThan(value: Int): List<Entity682>
}

@Service
@Transactional
class Service682(private val repo: Entity682Repository) {
    fun findAll(): List<Entity682> = repo.findAll()
    fun findByName(name: String): List<Entity682> = repo.findByField1(name)
    fun save(entity: Entity682): Entity682 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity682>): List<Entity682> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
