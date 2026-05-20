package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_57")
data class Entity57(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity57Repository : org.springframework.data.jpa.repository.JpaRepository<Entity57, Long> {
    fun findByField1(field1: String): List<Entity57>
    fun findByField3GreaterThan(value: Int): List<Entity57>
}

@Service
@Transactional
class Service57(private val repo: Entity57Repository) {
    fun findAll(): List<Entity57> = repo.findAll()
    fun findByName(name: String): List<Entity57> = repo.findByField1(name)
    fun save(entity: Entity57): Entity57 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity57>): List<Entity57> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
