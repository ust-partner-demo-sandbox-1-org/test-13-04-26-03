package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_261")
data class Entity261(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity261Repository : org.springframework.data.jpa.repository.JpaRepository<Entity261, Long> {
    fun findByField1(field1: String): List<Entity261>
    fun findByField3GreaterThan(value: Int): List<Entity261>
}

@Service
@Transactional
class Service261(private val repo: Entity261Repository) {
    fun findAll(): List<Entity261> = repo.findAll()
    fun findByName(name: String): List<Entity261> = repo.findByField1(name)
    fun save(entity: Entity261): Entity261 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity261>): List<Entity261> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
