package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_543")
data class Entity543(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity543Repository : org.springframework.data.jpa.repository.JpaRepository<Entity543, Long> {
    fun findByField1(field1: String): List<Entity543>
    fun findByField3GreaterThan(value: Int): List<Entity543>
}

@Service
@Transactional
class Service543(private val repo: Entity543Repository) {
    fun findAll(): List<Entity543> = repo.findAll()
    fun findByName(name: String): List<Entity543> = repo.findByField1(name)
    fun save(entity: Entity543): Entity543 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity543>): List<Entity543> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
