package com.example.generated.module11

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_235")
data class Entity235(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity235Repository : org.springframework.data.jpa.repository.JpaRepository<Entity235, Long> {
    fun findByField1(field1: String): List<Entity235>
    fun findByField3GreaterThan(value: Int): List<Entity235>
}

@Service
@Transactional
class Service235(private val repo: Entity235Repository) {
    fun findAll(): List<Entity235> = repo.findAll()
    fun findByName(name: String): List<Entity235> = repo.findByField1(name)
    fun save(entity: Entity235): Entity235 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity235>): List<Entity235> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
