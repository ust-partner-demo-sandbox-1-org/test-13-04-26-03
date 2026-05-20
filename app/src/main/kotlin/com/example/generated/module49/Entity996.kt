package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_996")
data class Entity996(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity996Repository : org.springframework.data.jpa.repository.JpaRepository<Entity996, Long> {
    fun findByField1(field1: String): List<Entity996>
    fun findByField3GreaterThan(value: Int): List<Entity996>
}

@Service
@Transactional
class Service996(private val repo: Entity996Repository) {
    fun findAll(): List<Entity996> = repo.findAll()
    fun findByName(name: String): List<Entity996> = repo.findByField1(name)
    fun save(entity: Entity996): Entity996 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity996>): List<Entity996> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
