package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_334")
data class Entity334(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity334Repository : org.springframework.data.jpa.repository.JpaRepository<Entity334, Long> {
    fun findByField1(field1: String): List<Entity334>
    fun findByField3GreaterThan(value: Int): List<Entity334>
}

@Service
@Transactional
class Service334(private val repo: Entity334Repository) {
    fun findAll(): List<Entity334> = repo.findAll()
    fun findByName(name: String): List<Entity334> = repo.findByField1(name)
    fun save(entity: Entity334): Entity334 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity334>): List<Entity334> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
