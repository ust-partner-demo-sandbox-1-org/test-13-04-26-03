package com.example.generated.module18

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_364")
data class Entity364(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity364Repository : org.springframework.data.jpa.repository.JpaRepository<Entity364, Long> {
    fun findByField1(field1: String): List<Entity364>
    fun findByField3GreaterThan(value: Int): List<Entity364>
}

@Service
@Transactional
class Service364(private val repo: Entity364Repository) {
    fun findAll(): List<Entity364> = repo.findAll()
    fun findByName(name: String): List<Entity364> = repo.findByField1(name)
    fun save(entity: Entity364): Entity364 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity364>): List<Entity364> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
