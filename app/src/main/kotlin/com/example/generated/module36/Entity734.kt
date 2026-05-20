package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_734")
data class Entity734(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity734Repository : org.springframework.data.jpa.repository.JpaRepository<Entity734, Long> {
    fun findByField1(field1: String): List<Entity734>
    fun findByField3GreaterThan(value: Int): List<Entity734>
}

@Service
@Transactional
class Service734(private val repo: Entity734Repository) {
    fun findAll(): List<Entity734> = repo.findAll()
    fun findByName(name: String): List<Entity734> = repo.findByField1(name)
    fun save(entity: Entity734): Entity734 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity734>): List<Entity734> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
