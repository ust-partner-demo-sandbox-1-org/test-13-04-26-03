package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_121")
data class Entity121(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity121Repository : org.springframework.data.jpa.repository.JpaRepository<Entity121, Long> {
    fun findByField1(field1: String): List<Entity121>
    fun findByField3GreaterThan(value: Int): List<Entity121>
}

@Service
@Transactional
class Service121(private val repo: Entity121Repository) {
    fun findAll(): List<Entity121> = repo.findAll()
    fun findByName(name: String): List<Entity121> = repo.findByField1(name)
    fun save(entity: Entity121): Entity121 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity121>): List<Entity121> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
