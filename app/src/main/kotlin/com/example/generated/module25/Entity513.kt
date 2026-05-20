package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_513")
data class Entity513(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity513Repository : org.springframework.data.jpa.repository.JpaRepository<Entity513, Long> {
    fun findByField1(field1: String): List<Entity513>
    fun findByField3GreaterThan(value: Int): List<Entity513>
}

@Service
@Transactional
class Service513(private val repo: Entity513Repository) {
    fun findAll(): List<Entity513> = repo.findAll()
    fun findByName(name: String): List<Entity513> = repo.findByField1(name)
    fun save(entity: Entity513): Entity513 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity513>): List<Entity513> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
