package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_841")
data class Entity841(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity841Repository : org.springframework.data.jpa.repository.JpaRepository<Entity841, Long> {
    fun findByField1(field1: String): List<Entity841>
    fun findByField3GreaterThan(value: Int): List<Entity841>
}

@Service
@Transactional
class Service841(private val repo: Entity841Repository) {
    fun findAll(): List<Entity841> = repo.findAll()
    fun findByName(name: String): List<Entity841> = repo.findByField1(name)
    fun save(entity: Entity841): Entity841 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity841>): List<Entity841> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
