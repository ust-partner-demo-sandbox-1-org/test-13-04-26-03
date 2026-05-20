package com.example.generated.module15

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_311")
data class Entity311(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity311Repository : org.springframework.data.jpa.repository.JpaRepository<Entity311, Long> {
    fun findByField1(field1: String): List<Entity311>
    fun findByField3GreaterThan(value: Int): List<Entity311>
}

@Service
@Transactional
class Service311(private val repo: Entity311Repository) {
    fun findAll(): List<Entity311> = repo.findAll()
    fun findByName(name: String): List<Entity311> = repo.findByField1(name)
    fun save(entity: Entity311): Entity311 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity311>): List<Entity311> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
