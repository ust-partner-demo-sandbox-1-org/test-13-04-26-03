package com.example.generated.module48

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_969")
data class Entity969(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity969Repository : org.springframework.data.jpa.repository.JpaRepository<Entity969, Long> {
    fun findByField1(field1: String): List<Entity969>
    fun findByField3GreaterThan(value: Int): List<Entity969>
}

@Service
@Transactional
class Service969(private val repo: Entity969Repository) {
    fun findAll(): List<Entity969> = repo.findAll()
    fun findByName(name: String): List<Entity969> = repo.findByField1(name)
    fun save(entity: Entity969): Entity969 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity969>): List<Entity969> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
