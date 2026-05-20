package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_858")
data class Entity858(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity858Repository : org.springframework.data.jpa.repository.JpaRepository<Entity858, Long> {
    fun findByField1(field1: String): List<Entity858>
    fun findByField3GreaterThan(value: Int): List<Entity858>
}

@Service
@Transactional
class Service858(private val repo: Entity858Repository) {
    fun findAll(): List<Entity858> = repo.findAll()
    fun findByName(name: String): List<Entity858> = repo.findByField1(name)
    fun save(entity: Entity858): Entity858 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity858>): List<Entity858> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
