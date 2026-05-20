package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_795")
data class Entity795(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity795Repository : org.springframework.data.jpa.repository.JpaRepository<Entity795, Long> {
    fun findByField1(field1: String): List<Entity795>
    fun findByField3GreaterThan(value: Int): List<Entity795>
}

@Service
@Transactional
class Service795(private val repo: Entity795Repository) {
    fun findAll(): List<Entity795> = repo.findAll()
    fun findByName(name: String): List<Entity795> = repo.findByField1(name)
    fun save(entity: Entity795): Entity795 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity795>): List<Entity795> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
