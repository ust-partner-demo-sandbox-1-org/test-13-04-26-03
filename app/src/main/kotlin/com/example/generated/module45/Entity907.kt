package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_907")
data class Entity907(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity907Repository : org.springframework.data.jpa.repository.JpaRepository<Entity907, Long> {
    fun findByField1(field1: String): List<Entity907>
    fun findByField3GreaterThan(value: Int): List<Entity907>
}

@Service
@Transactional
class Service907(private val repo: Entity907Repository) {
    fun findAll(): List<Entity907> = repo.findAll()
    fun findByName(name: String): List<Entity907> = repo.findByField1(name)
    fun save(entity: Entity907): Entity907 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity907>): List<Entity907> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
