package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_808")
data class Entity808(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity808Repository : org.springframework.data.jpa.repository.JpaRepository<Entity808, Long> {
    fun findByField1(field1: String): List<Entity808>
    fun findByField3GreaterThan(value: Int): List<Entity808>
}

@Service
@Transactional
class Service808(private val repo: Entity808Repository) {
    fun findAll(): List<Entity808> = repo.findAll()
    fun findByName(name: String): List<Entity808> = repo.findByField1(name)
    fun save(entity: Entity808): Entity808 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity808>): List<Entity808> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
