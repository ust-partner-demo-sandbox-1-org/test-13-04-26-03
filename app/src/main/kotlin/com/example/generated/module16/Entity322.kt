package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_322")
data class Entity322(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity322Repository : org.springframework.data.jpa.repository.JpaRepository<Entity322, Long> {
    fun findByField1(field1: String): List<Entity322>
    fun findByField3GreaterThan(value: Int): List<Entity322>
}

@Service
@Transactional
class Service322(private val repo: Entity322Repository) {
    fun findAll(): List<Entity322> = repo.findAll()
    fun findByName(name: String): List<Entity322> = repo.findByField1(name)
    fun save(entity: Entity322): Entity322 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity322>): List<Entity322> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
