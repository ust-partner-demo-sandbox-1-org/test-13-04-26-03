package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_733")
data class Entity733(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity733Repository : org.springframework.data.jpa.repository.JpaRepository<Entity733, Long> {
    fun findByField1(field1: String): List<Entity733>
    fun findByField3GreaterThan(value: Int): List<Entity733>
}

@Service
@Transactional
class Service733(private val repo: Entity733Repository) {
    fun findAll(): List<Entity733> = repo.findAll()
    fun findByName(name: String): List<Entity733> = repo.findByField1(name)
    fun save(entity: Entity733): Entity733 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity733>): List<Entity733> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
