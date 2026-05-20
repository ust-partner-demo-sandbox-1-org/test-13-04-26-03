package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_516")
data class Entity516(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity516Repository : org.springframework.data.jpa.repository.JpaRepository<Entity516, Long> {
    fun findByField1(field1: String): List<Entity516>
    fun findByField3GreaterThan(value: Int): List<Entity516>
}

@Service
@Transactional
class Service516(private val repo: Entity516Repository) {
    fun findAll(): List<Entity516> = repo.findAll()
    fun findByName(name: String): List<Entity516> = repo.findByField1(name)
    fun save(entity: Entity516): Entity516 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity516>): List<Entity516> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
