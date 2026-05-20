package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_849")
data class Entity849(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity849Repository : org.springframework.data.jpa.repository.JpaRepository<Entity849, Long> {
    fun findByField1(field1: String): List<Entity849>
    fun findByField3GreaterThan(value: Int): List<Entity849>
}

@Service
@Transactional
class Service849(private val repo: Entity849Repository) {
    fun findAll(): List<Entity849> = repo.findAll()
    fun findByName(name: String): List<Entity849> = repo.findByField1(name)
    fun save(entity: Entity849): Entity849 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity849>): List<Entity849> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
