package com.example.generated.module11

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_236")
data class Entity236(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity236Repository : org.springframework.data.jpa.repository.JpaRepository<Entity236, Long> {
    fun findByField1(field1: String): List<Entity236>
    fun findByField3GreaterThan(value: Int): List<Entity236>
}

@Service
@Transactional
class Service236(private val repo: Entity236Repository) {
    fun findAll(): List<Entity236> = repo.findAll()
    fun findByName(name: String): List<Entity236> = repo.findByField1(name)
    fun save(entity: Entity236): Entity236 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity236>): List<Entity236> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
