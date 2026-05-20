package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_819")
data class Entity819(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity819Repository : org.springframework.data.jpa.repository.JpaRepository<Entity819, Long> {
    fun findByField1(field1: String): List<Entity819>
    fun findByField3GreaterThan(value: Int): List<Entity819>
}

@Service
@Transactional
class Service819(private val repo: Entity819Repository) {
    fun findAll(): List<Entity819> = repo.findAll()
    fun findByName(name: String): List<Entity819> = repo.findByField1(name)
    fun save(entity: Entity819): Entity819 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity819>): List<Entity819> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
