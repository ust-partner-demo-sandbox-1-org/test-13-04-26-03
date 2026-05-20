package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_899")
data class Entity899(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity899Repository : org.springframework.data.jpa.repository.JpaRepository<Entity899, Long> {
    fun findByField1(field1: String): List<Entity899>
    fun findByField3GreaterThan(value: Int): List<Entity899>
}

@Service
@Transactional
class Service899(private val repo: Entity899Repository) {
    fun findAll(): List<Entity899> = repo.findAll()
    fun findByName(name: String): List<Entity899> = repo.findByField1(name)
    fun save(entity: Entity899): Entity899 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity899>): List<Entity899> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
