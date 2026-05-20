package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_535")
data class Entity535(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity535Repository : org.springframework.data.jpa.repository.JpaRepository<Entity535, Long> {
    fun findByField1(field1: String): List<Entity535>
    fun findByField3GreaterThan(value: Int): List<Entity535>
}

@Service
@Transactional
class Service535(private val repo: Entity535Repository) {
    fun findAll(): List<Entity535> = repo.findAll()
    fun findByName(name: String): List<Entity535> = repo.findByField1(name)
    fun save(entity: Entity535): Entity535 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity535>): List<Entity535> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
