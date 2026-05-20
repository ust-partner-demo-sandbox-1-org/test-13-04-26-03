package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_668")
data class Entity668(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity668Repository : org.springframework.data.jpa.repository.JpaRepository<Entity668, Long> {
    fun findByField1(field1: String): List<Entity668>
    fun findByField3GreaterThan(value: Int): List<Entity668>
}

@Service
@Transactional
class Service668(private val repo: Entity668Repository) {
    fun findAll(): List<Entity668> = repo.findAll()
    fun findByName(name: String): List<Entity668> = repo.findByField1(name)
    fun save(entity: Entity668): Entity668 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity668>): List<Entity668> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
