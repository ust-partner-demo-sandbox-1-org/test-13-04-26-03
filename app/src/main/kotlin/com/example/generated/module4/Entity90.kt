package com.example.generated.module4

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_90")
data class Entity90(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity90Repository : org.springframework.data.jpa.repository.JpaRepository<Entity90, Long> {
    fun findByField1(field1: String): List<Entity90>
    fun findByField3GreaterThan(value: Int): List<Entity90>
}

@Service
@Transactional
class Service90(private val repo: Entity90Repository) {
    fun findAll(): List<Entity90> = repo.findAll()
    fun findByName(name: String): List<Entity90> = repo.findByField1(name)
    fun save(entity: Entity90): Entity90 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity90>): List<Entity90> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
