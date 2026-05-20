package com.example.generated.module11

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_221")
data class Entity221(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity221Repository : org.springframework.data.jpa.repository.JpaRepository<Entity221, Long> {
    fun findByField1(field1: String): List<Entity221>
    fun findByField3GreaterThan(value: Int): List<Entity221>
}

@Service
@Transactional
class Service221(private val repo: Entity221Repository) {
    fun findAll(): List<Entity221> = repo.findAll()
    fun findByName(name: String): List<Entity221> = repo.findByField1(name)
    fun save(entity: Entity221): Entity221 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity221>): List<Entity221> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
