package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_118")
data class Entity118(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity118Repository : org.springframework.data.jpa.repository.JpaRepository<Entity118, Long> {
    fun findByField1(field1: String): List<Entity118>
    fun findByField3GreaterThan(value: Int): List<Entity118>
}

@Service
@Transactional
class Service118(private val repo: Entity118Repository) {
    fun findAll(): List<Entity118> = repo.findAll()
    fun findByName(name: String): List<Entity118> = repo.findByField1(name)
    fun save(entity: Entity118): Entity118 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity118>): List<Entity118> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
