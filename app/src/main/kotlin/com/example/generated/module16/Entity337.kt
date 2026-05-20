package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_337")
data class Entity337(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity337Repository : org.springframework.data.jpa.repository.JpaRepository<Entity337, Long> {
    fun findByField1(field1: String): List<Entity337>
    fun findByField3GreaterThan(value: Int): List<Entity337>
}

@Service
@Transactional
class Service337(private val repo: Entity337Repository) {
    fun findAll(): List<Entity337> = repo.findAll()
    fun findByName(name: String): List<Entity337> = repo.findByField1(name)
    fun save(entity: Entity337): Entity337 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity337>): List<Entity337> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
