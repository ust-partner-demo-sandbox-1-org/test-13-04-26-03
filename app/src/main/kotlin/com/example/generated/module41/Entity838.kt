package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_838")
data class Entity838(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity838Repository : org.springframework.data.jpa.repository.JpaRepository<Entity838, Long> {
    fun findByField1(field1: String): List<Entity838>
    fun findByField3GreaterThan(value: Int): List<Entity838>
}

@Service
@Transactional
class Service838(private val repo: Entity838Repository) {
    fun findAll(): List<Entity838> = repo.findAll()
    fun findByName(name: String): List<Entity838> = repo.findByField1(name)
    fun save(entity: Entity838): Entity838 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity838>): List<Entity838> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
