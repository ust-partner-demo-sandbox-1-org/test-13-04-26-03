package com.example.generated.module43

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_869")
data class Entity869(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity869Repository : org.springframework.data.jpa.repository.JpaRepository<Entity869, Long> {
    fun findByField1(field1: String): List<Entity869>
    fun findByField3GreaterThan(value: Int): List<Entity869>
}

@Service
@Transactional
class Service869(private val repo: Entity869Repository) {
    fun findAll(): List<Entity869> = repo.findAll()
    fun findByName(name: String): List<Entity869> = repo.findByField1(name)
    fun save(entity: Entity869): Entity869 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity869>): List<Entity869> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
