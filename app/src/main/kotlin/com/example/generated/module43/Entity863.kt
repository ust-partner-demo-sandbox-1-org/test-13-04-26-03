package com.example.generated.module43

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_863")
data class Entity863(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity863Repository : org.springframework.data.jpa.repository.JpaRepository<Entity863, Long> {
    fun findByField1(field1: String): List<Entity863>
    fun findByField3GreaterThan(value: Int): List<Entity863>
}

@Service
@Transactional
class Service863(private val repo: Entity863Repository) {
    fun findAll(): List<Entity863> = repo.findAll()
    fun findByName(name: String): List<Entity863> = repo.findByField1(name)
    fun save(entity: Entity863): Entity863 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity863>): List<Entity863> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
