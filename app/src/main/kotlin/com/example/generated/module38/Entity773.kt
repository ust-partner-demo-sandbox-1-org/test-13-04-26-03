package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_773")
data class Entity773(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity773Repository : org.springframework.data.jpa.repository.JpaRepository<Entity773, Long> {
    fun findByField1(field1: String): List<Entity773>
    fun findByField3GreaterThan(value: Int): List<Entity773>
}

@Service
@Transactional
class Service773(private val repo: Entity773Repository) {
    fun findAll(): List<Entity773> = repo.findAll()
    fun findByName(name: String): List<Entity773> = repo.findByField1(name)
    fun save(entity: Entity773): Entity773 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity773>): List<Entity773> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
