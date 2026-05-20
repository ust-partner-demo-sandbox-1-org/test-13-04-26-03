package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_477")
data class Entity477(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity477Repository : org.springframework.data.jpa.repository.JpaRepository<Entity477, Long> {
    fun findByField1(field1: String): List<Entity477>
    fun findByField3GreaterThan(value: Int): List<Entity477>
}

@Service
@Transactional
class Service477(private val repo: Entity477Repository) {
    fun findAll(): List<Entity477> = repo.findAll()
    fun findByName(name: String): List<Entity477> = repo.findByField1(name)
    fun save(entity: Entity477): Entity477 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity477>): List<Entity477> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
