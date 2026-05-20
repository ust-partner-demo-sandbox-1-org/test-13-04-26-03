package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_138")
data class Entity138(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity138Repository : org.springframework.data.jpa.repository.JpaRepository<Entity138, Long> {
    fun findByField1(field1: String): List<Entity138>
    fun findByField3GreaterThan(value: Int): List<Entity138>
}

@Service
@Transactional
class Service138(private val repo: Entity138Repository) {
    fun findAll(): List<Entity138> = repo.findAll()
    fun findByName(name: String): List<Entity138> = repo.findByField1(name)
    fun save(entity: Entity138): Entity138 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity138>): List<Entity138> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
