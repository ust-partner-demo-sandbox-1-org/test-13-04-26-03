package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_929")
data class Entity929(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity929Repository : org.springframework.data.jpa.repository.JpaRepository<Entity929, Long> {
    fun findByField1(field1: String): List<Entity929>
    fun findByField3GreaterThan(value: Int): List<Entity929>
}

@Service
@Transactional
class Service929(private val repo: Entity929Repository) {
    fun findAll(): List<Entity929> = repo.findAll()
    fun findByName(name: String): List<Entity929> = repo.findByField1(name)
    fun save(entity: Entity929): Entity929 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity929>): List<Entity929> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
