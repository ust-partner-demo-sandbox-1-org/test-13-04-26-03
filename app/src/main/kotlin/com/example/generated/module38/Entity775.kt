package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_775")
data class Entity775(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity775Repository : org.springframework.data.jpa.repository.JpaRepository<Entity775, Long> {
    fun findByField1(field1: String): List<Entity775>
    fun findByField3GreaterThan(value: Int): List<Entity775>
}

@Service
@Transactional
class Service775(private val repo: Entity775Repository) {
    fun findAll(): List<Entity775> = repo.findAll()
    fun findByName(name: String): List<Entity775> = repo.findByField1(name)
    fun save(entity: Entity775): Entity775 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity775>): List<Entity775> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
