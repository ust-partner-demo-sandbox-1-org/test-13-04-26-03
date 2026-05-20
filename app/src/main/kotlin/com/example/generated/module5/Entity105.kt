package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_105")
data class Entity105(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity105Repository : org.springframework.data.jpa.repository.JpaRepository<Entity105, Long> {
    fun findByField1(field1: String): List<Entity105>
    fun findByField3GreaterThan(value: Int): List<Entity105>
}

@Service
@Transactional
class Service105(private val repo: Entity105Repository) {
    fun findAll(): List<Entity105> = repo.findAll()
    fun findByName(name: String): List<Entity105> = repo.findByField1(name)
    fun save(entity: Entity105): Entity105 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity105>): List<Entity105> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
