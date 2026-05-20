package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_551")
data class Entity551(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity551Repository : org.springframework.data.jpa.repository.JpaRepository<Entity551, Long> {
    fun findByField1(field1: String): List<Entity551>
    fun findByField3GreaterThan(value: Int): List<Entity551>
}

@Service
@Transactional
class Service551(private val repo: Entity551Repository) {
    fun findAll(): List<Entity551> = repo.findAll()
    fun findByName(name: String): List<Entity551> = repo.findByField1(name)
    fun save(entity: Entity551): Entity551 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity551>): List<Entity551> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
