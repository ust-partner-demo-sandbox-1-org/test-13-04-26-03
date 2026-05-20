package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_287")
data class Entity287(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity287Repository : org.springframework.data.jpa.repository.JpaRepository<Entity287, Long> {
    fun findByField1(field1: String): List<Entity287>
    fun findByField3GreaterThan(value: Int): List<Entity287>
}

@Service
@Transactional
class Service287(private val repo: Entity287Repository) {
    fun findAll(): List<Entity287> = repo.findAll()
    fun findByName(name: String): List<Entity287> = repo.findByField1(name)
    fun save(entity: Entity287): Entity287 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity287>): List<Entity287> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
