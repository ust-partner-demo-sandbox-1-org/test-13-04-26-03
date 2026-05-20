package com.example.generated.module35

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_703")
data class Entity703(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity703Repository : org.springframework.data.jpa.repository.JpaRepository<Entity703, Long> {
    fun findByField1(field1: String): List<Entity703>
    fun findByField3GreaterThan(value: Int): List<Entity703>
}

@Service
@Transactional
class Service703(private val repo: Entity703Repository) {
    fun findAll(): List<Entity703> = repo.findAll()
    fun findByName(name: String): List<Entity703> = repo.findByField1(name)
    fun save(entity: Entity703): Entity703 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity703>): List<Entity703> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
