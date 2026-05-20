package com.example.generated.module15

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_302")
data class Entity302(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity302Repository : org.springframework.data.jpa.repository.JpaRepository<Entity302, Long> {
    fun findByField1(field1: String): List<Entity302>
    fun findByField3GreaterThan(value: Int): List<Entity302>
}

@Service
@Transactional
class Service302(private val repo: Entity302Repository) {
    fun findAll(): List<Entity302> = repo.findAll()
    fun findByName(name: String): List<Entity302> = repo.findByField1(name)
    fun save(entity: Entity302): Entity302 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity302>): List<Entity302> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
