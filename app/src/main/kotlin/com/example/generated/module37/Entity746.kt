package com.example.generated.module37

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_746")
data class Entity746(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity746Repository : org.springframework.data.jpa.repository.JpaRepository<Entity746, Long> {
    fun findByField1(field1: String): List<Entity746>
    fun findByField3GreaterThan(value: Int): List<Entity746>
}

@Service
@Transactional
class Service746(private val repo: Entity746Repository) {
    fun findAll(): List<Entity746> = repo.findAll()
    fun findByName(name: String): List<Entity746> = repo.findByField1(name)
    fun save(entity: Entity746): Entity746 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity746>): List<Entity746> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
