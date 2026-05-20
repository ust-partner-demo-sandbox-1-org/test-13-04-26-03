package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_610")
data class Entity610(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity610Repository : org.springframework.data.jpa.repository.JpaRepository<Entity610, Long> {
    fun findByField1(field1: String): List<Entity610>
    fun findByField3GreaterThan(value: Int): List<Entity610>
}

@Service
@Transactional
class Service610(private val repo: Entity610Repository) {
    fun findAll(): List<Entity610> = repo.findAll()
    fun findByName(name: String): List<Entity610> = repo.findByField1(name)
    fun save(entity: Entity610): Entity610 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity610>): List<Entity610> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
