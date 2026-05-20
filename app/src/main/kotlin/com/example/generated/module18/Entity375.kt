package com.example.generated.module18

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_375")
data class Entity375(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity375Repository : org.springframework.data.jpa.repository.JpaRepository<Entity375, Long> {
    fun findByField1(field1: String): List<Entity375>
    fun findByField3GreaterThan(value: Int): List<Entity375>
}

@Service
@Transactional
class Service375(private val repo: Entity375Repository) {
    fun findAll(): List<Entity375> = repo.findAll()
    fun findByName(name: String): List<Entity375> = repo.findByField1(name)
    fun save(entity: Entity375): Entity375 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity375>): List<Entity375> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
