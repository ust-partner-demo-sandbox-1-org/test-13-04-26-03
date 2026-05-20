package com.example.generated.module4

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_83")
data class Entity83(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity83Repository : org.springframework.data.jpa.repository.JpaRepository<Entity83, Long> {
    fun findByField1(field1: String): List<Entity83>
    fun findByField3GreaterThan(value: Int): List<Entity83>
}

@Service
@Transactional
class Service83(private val repo: Entity83Repository) {
    fun findAll(): List<Entity83> = repo.findAll()
    fun findByName(name: String): List<Entity83> = repo.findByField1(name)
    fun save(entity: Entity83): Entity83 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity83>): List<Entity83> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
