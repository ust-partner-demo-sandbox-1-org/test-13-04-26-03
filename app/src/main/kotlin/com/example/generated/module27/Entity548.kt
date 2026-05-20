package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_548")
data class Entity548(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity548Repository : org.springframework.data.jpa.repository.JpaRepository<Entity548, Long> {
    fun findByField1(field1: String): List<Entity548>
    fun findByField3GreaterThan(value: Int): List<Entity548>
}

@Service
@Transactional
class Service548(private val repo: Entity548Repository) {
    fun findAll(): List<Entity548> = repo.findAll()
    fun findByName(name: String): List<Entity548> = repo.findByField1(name)
    fun save(entity: Entity548): Entity548 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity548>): List<Entity548> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
