package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_530")
data class Entity530(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity530Repository : org.springframework.data.jpa.repository.JpaRepository<Entity530, Long> {
    fun findByField1(field1: String): List<Entity530>
    fun findByField3GreaterThan(value: Int): List<Entity530>
}

@Service
@Transactional
class Service530(private val repo: Entity530Repository) {
    fun findAll(): List<Entity530> = repo.findAll()
    fun findByName(name: String): List<Entity530> = repo.findByField1(name)
    fun save(entity: Entity530): Entity530 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity530>): List<Entity530> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
