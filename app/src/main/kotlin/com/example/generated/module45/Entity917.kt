package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_917")
data class Entity917(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity917Repository : org.springframework.data.jpa.repository.JpaRepository<Entity917, Long> {
    fun findByField1(field1: String): List<Entity917>
    fun findByField3GreaterThan(value: Int): List<Entity917>
}

@Service
@Transactional
class Service917(private val repo: Entity917Repository) {
    fun findAll(): List<Entity917> = repo.findAll()
    fun findByName(name: String): List<Entity917> = repo.findByField1(name)
    fun save(entity: Entity917): Entity917 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity917>): List<Entity917> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
