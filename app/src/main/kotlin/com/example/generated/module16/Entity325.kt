package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_325")
data class Entity325(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity325Repository : org.springframework.data.jpa.repository.JpaRepository<Entity325, Long> {
    fun findByField1(field1: String): List<Entity325>
    fun findByField3GreaterThan(value: Int): List<Entity325>
}

@Service
@Transactional
class Service325(private val repo: Entity325Repository) {
    fun findAll(): List<Entity325> = repo.findAll()
    fun findByName(name: String): List<Entity325> = repo.findByField1(name)
    fun save(entity: Entity325): Entity325 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity325>): List<Entity325> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
