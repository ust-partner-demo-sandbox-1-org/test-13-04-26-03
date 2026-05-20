package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_828")
data class Entity828(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity828Repository : org.springframework.data.jpa.repository.JpaRepository<Entity828, Long> {
    fun findByField1(field1: String): List<Entity828>
    fun findByField3GreaterThan(value: Int): List<Entity828>
}

@Service
@Transactional
class Service828(private val repo: Entity828Repository) {
    fun findAll(): List<Entity828> = repo.findAll()
    fun findByName(name: String): List<Entity828> = repo.findByField1(name)
    fun save(entity: Entity828): Entity828 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity828>): List<Entity828> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
