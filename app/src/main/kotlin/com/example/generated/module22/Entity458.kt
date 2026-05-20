package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_458")
data class Entity458(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity458Repository : org.springframework.data.jpa.repository.JpaRepository<Entity458, Long> {
    fun findByField1(field1: String): List<Entity458>
    fun findByField3GreaterThan(value: Int): List<Entity458>
}

@Service
@Transactional
class Service458(private val repo: Entity458Repository) {
    fun findAll(): List<Entity458> = repo.findAll()
    fun findByName(name: String): List<Entity458> = repo.findByField1(name)
    fun save(entity: Entity458): Entity458 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity458>): List<Entity458> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
