package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_273")
data class Entity273(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity273Repository : org.springframework.data.jpa.repository.JpaRepository<Entity273, Long> {
    fun findByField1(field1: String): List<Entity273>
    fun findByField3GreaterThan(value: Int): List<Entity273>
}

@Service
@Transactional
class Service273(private val repo: Entity273Repository) {
    fun findAll(): List<Entity273> = repo.findAll()
    fun findByName(name: String): List<Entity273> = repo.findByField1(name)
    fun save(entity: Entity273): Entity273 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity273>): List<Entity273> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
