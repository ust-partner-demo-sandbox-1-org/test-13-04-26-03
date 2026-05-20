package com.example.generated.module34

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_684")
data class Entity684(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity684Repository : org.springframework.data.jpa.repository.JpaRepository<Entity684, Long> {
    fun findByField1(field1: String): List<Entity684>
    fun findByField3GreaterThan(value: Int): List<Entity684>
}

@Service
@Transactional
class Service684(private val repo: Entity684Repository) {
    fun findAll(): List<Entity684> = repo.findAll()
    fun findByName(name: String): List<Entity684> = repo.findByField1(name)
    fun save(entity: Entity684): Entity684 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity684>): List<Entity684> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
