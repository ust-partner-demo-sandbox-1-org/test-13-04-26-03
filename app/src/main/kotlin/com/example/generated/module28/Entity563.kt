package com.example.generated.module28

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_563")
data class Entity563(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity563Repository : org.springframework.data.jpa.repository.JpaRepository<Entity563, Long> {
    fun findByField1(field1: String): List<Entity563>
    fun findByField3GreaterThan(value: Int): List<Entity563>
}

@Service
@Transactional
class Service563(private val repo: Entity563Repository) {
    fun findAll(): List<Entity563> = repo.findAll()
    fun findByName(name: String): List<Entity563> = repo.findByField1(name)
    fun save(entity: Entity563): Entity563 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity563>): List<Entity563> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
