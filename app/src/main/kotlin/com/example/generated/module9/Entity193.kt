package com.example.generated.module9

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_193")
data class Entity193(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity193Repository : org.springframework.data.jpa.repository.JpaRepository<Entity193, Long> {
    fun findByField1(field1: String): List<Entity193>
    fun findByField3GreaterThan(value: Int): List<Entity193>
}

@Service
@Transactional
class Service193(private val repo: Entity193Repository) {
    fun findAll(): List<Entity193> = repo.findAll()
    fun findByName(name: String): List<Entity193> = repo.findByField1(name)
    fun save(entity: Entity193): Entity193 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity193>): List<Entity193> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
