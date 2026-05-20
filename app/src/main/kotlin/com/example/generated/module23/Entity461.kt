package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_461")
data class Entity461(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity461Repository : org.springframework.data.jpa.repository.JpaRepository<Entity461, Long> {
    fun findByField1(field1: String): List<Entity461>
    fun findByField3GreaterThan(value: Int): List<Entity461>
}

@Service
@Transactional
class Service461(private val repo: Entity461Repository) {
    fun findAll(): List<Entity461> = repo.findAll()
    fun findByName(name: String): List<Entity461> = repo.findByField1(name)
    fun save(entity: Entity461): Entity461 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity461>): List<Entity461> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
