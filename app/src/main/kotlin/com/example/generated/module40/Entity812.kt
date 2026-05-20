package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_812")
data class Entity812(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity812Repository : org.springframework.data.jpa.repository.JpaRepository<Entity812, Long> {
    fun findByField1(field1: String): List<Entity812>
    fun findByField3GreaterThan(value: Int): List<Entity812>
}

@Service
@Transactional
class Service812(private val repo: Entity812Repository) {
    fun findAll(): List<Entity812> = repo.findAll()
    fun findByName(name: String): List<Entity812> = repo.findByField1(name)
    fun save(entity: Entity812): Entity812 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity812>): List<Entity812> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
