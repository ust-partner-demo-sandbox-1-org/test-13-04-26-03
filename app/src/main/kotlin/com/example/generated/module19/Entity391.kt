package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_391")
data class Entity391(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity391Repository : org.springframework.data.jpa.repository.JpaRepository<Entity391, Long> {
    fun findByField1(field1: String): List<Entity391>
    fun findByField3GreaterThan(value: Int): List<Entity391>
}

@Service
@Transactional
class Service391(private val repo: Entity391Repository) {
    fun findAll(): List<Entity391> = repo.findAll()
    fun findByName(name: String): List<Entity391> = repo.findByField1(name)
    fun save(entity: Entity391): Entity391 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity391>): List<Entity391> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
