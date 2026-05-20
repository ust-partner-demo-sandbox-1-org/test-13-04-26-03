package com.example.generated.module35

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_700")
data class Entity700(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity700Repository : org.springframework.data.jpa.repository.JpaRepository<Entity700, Long> {
    fun findByField1(field1: String): List<Entity700>
    fun findByField3GreaterThan(value: Int): List<Entity700>
}

@Service
@Transactional
class Service700(private val repo: Entity700Repository) {
    fun findAll(): List<Entity700> = repo.findAll()
    fun findByName(name: String): List<Entity700> = repo.findByField1(name)
    fun save(entity: Entity700): Entity700 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity700>): List<Entity700> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
