package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_558")
data class Entity558(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity558Repository : org.springframework.data.jpa.repository.JpaRepository<Entity558, Long> {
    fun findByField1(field1: String): List<Entity558>
    fun findByField3GreaterThan(value: Int): List<Entity558>
}

@Service
@Transactional
class Service558(private val repo: Entity558Repository) {
    fun findAll(): List<Entity558> = repo.findAll()
    fun findByName(name: String): List<Entity558> = repo.findByField1(name)
    fun save(entity: Entity558): Entity558 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity558>): List<Entity558> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
