package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_488")
data class Entity488(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity488Repository : org.springframework.data.jpa.repository.JpaRepository<Entity488, Long> {
    fun findByField1(field1: String): List<Entity488>
    fun findByField3GreaterThan(value: Int): List<Entity488>
}

@Service
@Transactional
class Service488(private val repo: Entity488Repository) {
    fun findAll(): List<Entity488> = repo.findAll()
    fun findByName(name: String): List<Entity488> = repo.findByField1(name)
    fun save(entity: Entity488): Entity488 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity488>): List<Entity488> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
