package com.example.generated.module1

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_32")
data class Entity32(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity32Repository : org.springframework.data.jpa.repository.JpaRepository<Entity32, Long> {
    fun findByField1(field1: String): List<Entity32>
    fun findByField3GreaterThan(value: Int): List<Entity32>
}

@Service
@Transactional
class Service32(private val repo: Entity32Repository) {
    fun findAll(): List<Entity32> = repo.findAll()
    fun findByName(name: String): List<Entity32> = repo.findByField1(name)
    fun save(entity: Entity32): Entity32 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity32>): List<Entity32> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
