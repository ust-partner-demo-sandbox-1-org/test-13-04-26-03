package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_156")
data class Entity156(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity156Repository : org.springframework.data.jpa.repository.JpaRepository<Entity156, Long> {
    fun findByField1(field1: String): List<Entity156>
    fun findByField3GreaterThan(value: Int): List<Entity156>
}

@Service
@Transactional
class Service156(private val repo: Entity156Repository) {
    fun findAll(): List<Entity156> = repo.findAll()
    fun findByName(name: String): List<Entity156> = repo.findByField1(name)
    fun save(entity: Entity156): Entity156 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity156>): List<Entity156> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
