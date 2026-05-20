package com.example.generated.module11

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_237")
data class Entity237(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity237Repository : org.springframework.data.jpa.repository.JpaRepository<Entity237, Long> {
    fun findByField1(field1: String): List<Entity237>
    fun findByField3GreaterThan(value: Int): List<Entity237>
}

@Service
@Transactional
class Service237(private val repo: Entity237Repository) {
    fun findAll(): List<Entity237> = repo.findAll()
    fun findByName(name: String): List<Entity237> = repo.findByField1(name)
    fun save(entity: Entity237): Entity237 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity237>): List<Entity237> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
