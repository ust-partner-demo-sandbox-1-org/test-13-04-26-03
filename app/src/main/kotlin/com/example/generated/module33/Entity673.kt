package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_673")
data class Entity673(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity673Repository : org.springframework.data.jpa.repository.JpaRepository<Entity673, Long> {
    fun findByField1(field1: String): List<Entity673>
    fun findByField3GreaterThan(value: Int): List<Entity673>
}

@Service
@Transactional
class Service673(private val repo: Entity673Repository) {
    fun findAll(): List<Entity673> = repo.findAll()
    fun findByName(name: String): List<Entity673> = repo.findByField1(name)
    fun save(entity: Entity673): Entity673 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity673>): List<Entity673> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
