package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_636")
data class Entity636(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity636Repository : org.springframework.data.jpa.repository.JpaRepository<Entity636, Long> {
    fun findByField1(field1: String): List<Entity636>
    fun findByField3GreaterThan(value: Int): List<Entity636>
}

@Service
@Transactional
class Service636(private val repo: Entity636Repository) {
    fun findAll(): List<Entity636> = repo.findAll()
    fun findByName(name: String): List<Entity636> = repo.findByField1(name)
    fun save(entity: Entity636): Entity636 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity636>): List<Entity636> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
