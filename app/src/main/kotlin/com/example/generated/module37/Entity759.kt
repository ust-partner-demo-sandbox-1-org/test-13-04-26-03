package com.example.generated.module37

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_759")
data class Entity759(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity759Repository : org.springframework.data.jpa.repository.JpaRepository<Entity759, Long> {
    fun findByField1(field1: String): List<Entity759>
    fun findByField3GreaterThan(value: Int): List<Entity759>
}

@Service
@Transactional
class Service759(private val repo: Entity759Repository) {
    fun findAll(): List<Entity759> = repo.findAll()
    fun findByName(name: String): List<Entity759> = repo.findByField1(name)
    fun save(entity: Entity759): Entity759 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity759>): List<Entity759> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
