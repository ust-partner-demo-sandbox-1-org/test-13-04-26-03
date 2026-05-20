package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_137")
data class Entity137(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity137Repository : org.springframework.data.jpa.repository.JpaRepository<Entity137, Long> {
    fun findByField1(field1: String): List<Entity137>
    fun findByField3GreaterThan(value: Int): List<Entity137>
}

@Service
@Transactional
class Service137(private val repo: Entity137Repository) {
    fun findAll(): List<Entity137> = repo.findAll()
    fun findByName(name: String): List<Entity137> = repo.findByField1(name)
    fun save(entity: Entity137): Entity137 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity137>): List<Entity137> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
