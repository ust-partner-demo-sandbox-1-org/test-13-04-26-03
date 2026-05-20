package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_830")
data class Entity830(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity830Repository : org.springframework.data.jpa.repository.JpaRepository<Entity830, Long> {
    fun findByField1(field1: String): List<Entity830>
    fun findByField3GreaterThan(value: Int): List<Entity830>
}

@Service
@Transactional
class Service830(private val repo: Entity830Repository) {
    fun findAll(): List<Entity830> = repo.findAll()
    fun findByName(name: String): List<Entity830> = repo.findByField1(name)
    fun save(entity: Entity830): Entity830 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity830>): List<Entity830> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
