package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_446")
data class Entity446(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity446Repository : org.springframework.data.jpa.repository.JpaRepository<Entity446, Long> {
    fun findByField1(field1: String): List<Entity446>
    fun findByField3GreaterThan(value: Int): List<Entity446>
}

@Service
@Transactional
class Service446(private val repo: Entity446Repository) {
    fun findAll(): List<Entity446> = repo.findAll()
    fun findByName(name: String): List<Entity446> = repo.findByField1(name)
    fun save(entity: Entity446): Entity446 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity446>): List<Entity446> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
