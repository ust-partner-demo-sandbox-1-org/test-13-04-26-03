package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_66")
data class Entity66(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity66Repository : org.springframework.data.jpa.repository.JpaRepository<Entity66, Long> {
    fun findByField1(field1: String): List<Entity66>
    fun findByField3GreaterThan(value: Int): List<Entity66>
}

@Service
@Transactional
class Service66(private val repo: Entity66Repository) {
    fun findAll(): List<Entity66> = repo.findAll()
    fun findByName(name: String): List<Entity66> = repo.findByField1(name)
    fun save(entity: Entity66): Entity66 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity66>): List<Entity66> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
