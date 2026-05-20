package com.example.generated.module34

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_686")
data class Entity686(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity686Repository : org.springframework.data.jpa.repository.JpaRepository<Entity686, Long> {
    fun findByField1(field1: String): List<Entity686>
    fun findByField3GreaterThan(value: Int): List<Entity686>
}

@Service
@Transactional
class Service686(private val repo: Entity686Repository) {
    fun findAll(): List<Entity686> = repo.findAll()
    fun findByName(name: String): List<Entity686> = repo.findByField1(name)
    fun save(entity: Entity686): Entity686 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity686>): List<Entity686> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
