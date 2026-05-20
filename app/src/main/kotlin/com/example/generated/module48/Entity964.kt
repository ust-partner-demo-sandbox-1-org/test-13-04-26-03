package com.example.generated.module48

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_964")
data class Entity964(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity964Repository : org.springframework.data.jpa.repository.JpaRepository<Entity964, Long> {
    fun findByField1(field1: String): List<Entity964>
    fun findByField3GreaterThan(value: Int): List<Entity964>
}

@Service
@Transactional
class Service964(private val repo: Entity964Repository) {
    fun findAll(): List<Entity964> = repo.findAll()
    fun findByName(name: String): List<Entity964> = repo.findByField1(name)
    fun save(entity: Entity964): Entity964 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity964>): List<Entity964> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
