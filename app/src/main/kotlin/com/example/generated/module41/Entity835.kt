package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_835")
data class Entity835(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity835Repository : org.springframework.data.jpa.repository.JpaRepository<Entity835, Long> {
    fun findByField1(field1: String): List<Entity835>
    fun findByField3GreaterThan(value: Int): List<Entity835>
}

@Service
@Transactional
class Service835(private val repo: Entity835Repository) {
    fun findAll(): List<Entity835> = repo.findAll()
    fun findByName(name: String): List<Entity835> = repo.findByField1(name)
    fun save(entity: Entity835): Entity835 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity835>): List<Entity835> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
