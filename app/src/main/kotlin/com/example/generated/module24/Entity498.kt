package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_498")
data class Entity498(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity498Repository : org.springframework.data.jpa.repository.JpaRepository<Entity498, Long> {
    fun findByField1(field1: String): List<Entity498>
    fun findByField3GreaterThan(value: Int): List<Entity498>
}

@Service
@Transactional
class Service498(private val repo: Entity498Repository) {
    fun findAll(): List<Entity498> = repo.findAll()
    fun findByName(name: String): List<Entity498> = repo.findByField1(name)
    fun save(entity: Entity498): Entity498 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity498>): List<Entity498> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
