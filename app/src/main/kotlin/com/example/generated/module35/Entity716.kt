package com.example.generated.module35

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_716")
data class Entity716(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity716Repository : org.springframework.data.jpa.repository.JpaRepository<Entity716, Long> {
    fun findByField1(field1: String): List<Entity716>
    fun findByField3GreaterThan(value: Int): List<Entity716>
}

@Service
@Transactional
class Service716(private val repo: Entity716Repository) {
    fun findAll(): List<Entity716> = repo.findAll()
    fun findByName(name: String): List<Entity716> = repo.findByField1(name)
    fun save(entity: Entity716): Entity716 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity716>): List<Entity716> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
