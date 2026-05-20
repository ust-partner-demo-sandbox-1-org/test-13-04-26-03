package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_405")
data class Entity405(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity405Repository : org.springframework.data.jpa.repository.JpaRepository<Entity405, Long> {
    fun findByField1(field1: String): List<Entity405>
    fun findByField3GreaterThan(value: Int): List<Entity405>
}

@Service
@Transactional
class Service405(private val repo: Entity405Repository) {
    fun findAll(): List<Entity405> = repo.findAll()
    fun findByName(name: String): List<Entity405> = repo.findByField1(name)
    fun save(entity: Entity405): Entity405 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity405>): List<Entity405> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
