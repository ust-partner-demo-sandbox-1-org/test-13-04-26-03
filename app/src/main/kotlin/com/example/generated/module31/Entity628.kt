package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_628")
data class Entity628(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity628Repository : org.springframework.data.jpa.repository.JpaRepository<Entity628, Long> {
    fun findByField1(field1: String): List<Entity628>
    fun findByField3GreaterThan(value: Int): List<Entity628>
}

@Service
@Transactional
class Service628(private val repo: Entity628Repository) {
    fun findAll(): List<Entity628> = repo.findAll()
    fun findByName(name: String): List<Entity628> = repo.findByField1(name)
    fun save(entity: Entity628): Entity628 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity628>): List<Entity628> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
