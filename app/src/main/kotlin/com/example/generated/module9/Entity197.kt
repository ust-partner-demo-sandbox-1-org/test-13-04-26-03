package com.example.generated.module9

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_197")
data class Entity197(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity197Repository : org.springframework.data.jpa.repository.JpaRepository<Entity197, Long> {
    fun findByField1(field1: String): List<Entity197>
    fun findByField3GreaterThan(value: Int): List<Entity197>
}

@Service
@Transactional
class Service197(private val repo: Entity197Repository) {
    fun findAll(): List<Entity197> = repo.findAll()
    fun findByName(name: String): List<Entity197> = repo.findByField1(name)
    fun save(entity: Entity197): Entity197 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity197>): List<Entity197> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
