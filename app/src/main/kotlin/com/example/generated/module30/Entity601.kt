package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_601")
data class Entity601(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity601Repository : org.springframework.data.jpa.repository.JpaRepository<Entity601, Long> {
    fun findByField1(field1: String): List<Entity601>
    fun findByField3GreaterThan(value: Int): List<Entity601>
}

@Service
@Transactional
class Service601(private val repo: Entity601Repository) {
    fun findAll(): List<Entity601> = repo.findAll()
    fun findByName(name: String): List<Entity601> = repo.findByField1(name)
    fun save(entity: Entity601): Entity601 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity601>): List<Entity601> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
