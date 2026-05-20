package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_130")
data class Entity130(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity130Repository : org.springframework.data.jpa.repository.JpaRepository<Entity130, Long> {
    fun findByField1(field1: String): List<Entity130>
    fun findByField3GreaterThan(value: Int): List<Entity130>
}

@Service
@Transactional
class Service130(private val repo: Entity130Repository) {
    fun findAll(): List<Entity130> = repo.findAll()
    fun findByName(name: String): List<Entity130> = repo.findByField1(name)
    fun save(entity: Entity130): Entity130 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity130>): List<Entity130> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
