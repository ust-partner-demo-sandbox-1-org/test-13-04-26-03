package com.example.generated.module4

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_97")
data class Entity97(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity97Repository : org.springframework.data.jpa.repository.JpaRepository<Entity97, Long> {
    fun findByField1(field1: String): List<Entity97>
    fun findByField3GreaterThan(value: Int): List<Entity97>
}

@Service
@Transactional
class Service97(private val repo: Entity97Repository) {
    fun findAll(): List<Entity97> = repo.findAll()
    fun findByName(name: String): List<Entity97> = repo.findByField1(name)
    fun save(entity: Entity97): Entity97 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity97>): List<Entity97> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
