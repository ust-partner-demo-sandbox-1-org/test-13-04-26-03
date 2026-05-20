package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_817")
data class Entity817(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity817Repository : org.springframework.data.jpa.repository.JpaRepository<Entity817, Long> {
    fun findByField1(field1: String): List<Entity817>
    fun findByField3GreaterThan(value: Int): List<Entity817>
}

@Service
@Transactional
class Service817(private val repo: Entity817Repository) {
    fun findAll(): List<Entity817> = repo.findAll()
    fun findByName(name: String): List<Entity817> = repo.findByField1(name)
    fun save(entity: Entity817): Entity817 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity817>): List<Entity817> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
