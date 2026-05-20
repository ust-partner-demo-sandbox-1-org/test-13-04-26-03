package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_796")
data class Entity796(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity796Repository : org.springframework.data.jpa.repository.JpaRepository<Entity796, Long> {
    fun findByField1(field1: String): List<Entity796>
    fun findByField3GreaterThan(value: Int): List<Entity796>
}

@Service
@Transactional
class Service796(private val repo: Entity796Repository) {
    fun findAll(): List<Entity796> = repo.findAll()
    fun findByName(name: String): List<Entity796> = repo.findByField1(name)
    fun save(entity: Entity796): Entity796 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity796>): List<Entity796> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
