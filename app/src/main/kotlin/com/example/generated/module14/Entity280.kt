package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_280")
data class Entity280(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity280Repository : org.springframework.data.jpa.repository.JpaRepository<Entity280, Long> {
    fun findByField1(field1: String): List<Entity280>
    fun findByField3GreaterThan(value: Int): List<Entity280>
}

@Service
@Transactional
class Service280(private val repo: Entity280Repository) {
    fun findAll(): List<Entity280> = repo.findAll()
    fun findByName(name: String): List<Entity280> = repo.findByField1(name)
    fun save(entity: Entity280): Entity280 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity280>): List<Entity280> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
