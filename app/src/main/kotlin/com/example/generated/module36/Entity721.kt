package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_721")
data class Entity721(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity721Repository : org.springframework.data.jpa.repository.JpaRepository<Entity721, Long> {
    fun findByField1(field1: String): List<Entity721>
    fun findByField3GreaterThan(value: Int): List<Entity721>
}

@Service
@Transactional
class Service721(private val repo: Entity721Repository) {
    fun findAll(): List<Entity721> = repo.findAll()
    fun findByName(name: String): List<Entity721> = repo.findByField1(name)
    fun save(entity: Entity721): Entity721 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity721>): List<Entity721> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
