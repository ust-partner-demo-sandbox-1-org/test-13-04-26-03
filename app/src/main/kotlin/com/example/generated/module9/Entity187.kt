package com.example.generated.module9

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_187")
data class Entity187(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity187Repository : org.springframework.data.jpa.repository.JpaRepository<Entity187, Long> {
    fun findByField1(field1: String): List<Entity187>
    fun findByField3GreaterThan(value: Int): List<Entity187>
}

@Service
@Transactional
class Service187(private val repo: Entity187Repository) {
    fun findAll(): List<Entity187> = repo.findAll()
    fun findByName(name: String): List<Entity187> = repo.findByField1(name)
    fun save(entity: Entity187): Entity187 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity187>): List<Entity187> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
