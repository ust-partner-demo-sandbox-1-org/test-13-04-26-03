package com.example.generated.module35

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_717")
data class Entity717(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity717Repository : org.springframework.data.jpa.repository.JpaRepository<Entity717, Long> {
    fun findByField1(field1: String): List<Entity717>
    fun findByField3GreaterThan(value: Int): List<Entity717>
}

@Service
@Transactional
class Service717(private val repo: Entity717Repository) {
    fun findAll(): List<Entity717> = repo.findAll()
    fun findByName(name: String): List<Entity717> = repo.findByField1(name)
    fun save(entity: Entity717): Entity717 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity717>): List<Entity717> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
