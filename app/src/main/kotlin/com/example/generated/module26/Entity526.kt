package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_526")
data class Entity526(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity526Repository : org.springframework.data.jpa.repository.JpaRepository<Entity526, Long> {
    fun findByField1(field1: String): List<Entity526>
    fun findByField3GreaterThan(value: Int): List<Entity526>
}

@Service
@Transactional
class Service526(private val repo: Entity526Repository) {
    fun findAll(): List<Entity526> = repo.findAll()
    fun findByName(name: String): List<Entity526> = repo.findByField1(name)
    fun save(entity: Entity526): Entity526 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity526>): List<Entity526> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
