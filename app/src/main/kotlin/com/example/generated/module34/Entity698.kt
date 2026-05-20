package com.example.generated.module34

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_698")
data class Entity698(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity698Repository : org.springframework.data.jpa.repository.JpaRepository<Entity698, Long> {
    fun findByField1(field1: String): List<Entity698>
    fun findByField3GreaterThan(value: Int): List<Entity698>
}

@Service
@Transactional
class Service698(private val repo: Entity698Repository) {
    fun findAll(): List<Entity698> = repo.findAll()
    fun findByName(name: String): List<Entity698> = repo.findByField1(name)
    fun save(entity: Entity698): Entity698 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity698>): List<Entity698> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
