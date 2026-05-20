package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_787")
data class Entity787(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity787Repository : org.springframework.data.jpa.repository.JpaRepository<Entity787, Long> {
    fun findByField1(field1: String): List<Entity787>
    fun findByField3GreaterThan(value: Int): List<Entity787>
}

@Service
@Transactional
class Service787(private val repo: Entity787Repository) {
    fun findAll(): List<Entity787> = repo.findAll()
    fun findByName(name: String): List<Entity787> = repo.findByField1(name)
    fun save(entity: Entity787): Entity787 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity787>): List<Entity787> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
