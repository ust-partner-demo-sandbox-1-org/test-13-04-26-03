package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_667")
data class Entity667(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity667Repository : org.springframework.data.jpa.repository.JpaRepository<Entity667, Long> {
    fun findByField1(field1: String): List<Entity667>
    fun findByField3GreaterThan(value: Int): List<Entity667>
}

@Service
@Transactional
class Service667(private val repo: Entity667Repository) {
    fun findAll(): List<Entity667> = repo.findAll()
    fun findByName(name: String): List<Entity667> = repo.findByField1(name)
    fun save(entity: Entity667): Entity667 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity667>): List<Entity667> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
