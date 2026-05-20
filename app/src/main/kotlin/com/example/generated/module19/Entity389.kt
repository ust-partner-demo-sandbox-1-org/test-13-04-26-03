package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_389")
data class Entity389(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity389Repository : org.springframework.data.jpa.repository.JpaRepository<Entity389, Long> {
    fun findByField1(field1: String): List<Entity389>
    fun findByField3GreaterThan(value: Int): List<Entity389>
}

@Service
@Transactional
class Service389(private val repo: Entity389Repository) {
    fun findAll(): List<Entity389> = repo.findAll()
    fun findByName(name: String): List<Entity389> = repo.findByField1(name)
    fun save(entity: Entity389): Entity389 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity389>): List<Entity389> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
