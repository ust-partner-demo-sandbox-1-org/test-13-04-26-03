package com.example.generated.module32

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_658")
data class Entity658(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity658Repository : org.springframework.data.jpa.repository.JpaRepository<Entity658, Long> {
    fun findByField1(field1: String): List<Entity658>
    fun findByField3GreaterThan(value: Int): List<Entity658>
}

@Service
@Transactional
class Service658(private val repo: Entity658Repository) {
    fun findAll(): List<Entity658> = repo.findAll()
    fun findByName(name: String): List<Entity658> = repo.findByField1(name)
    fun save(entity: Entity658): Entity658 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity658>): List<Entity658> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
