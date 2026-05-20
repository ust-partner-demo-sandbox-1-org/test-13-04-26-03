package com.example.generated.module37

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_755")
data class Entity755(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity755Repository : org.springframework.data.jpa.repository.JpaRepository<Entity755, Long> {
    fun findByField1(field1: String): List<Entity755>
    fun findByField3GreaterThan(value: Int): List<Entity755>
}

@Service
@Transactional
class Service755(private val repo: Entity755Repository) {
    fun findAll(): List<Entity755> = repo.findAll()
    fun findByName(name: String): List<Entity755> = repo.findByField1(name)
    fun save(entity: Entity755): Entity755 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity755>): List<Entity755> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
