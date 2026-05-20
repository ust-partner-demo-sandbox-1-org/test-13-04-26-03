package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_120")
data class Entity120(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity120Repository : org.springframework.data.jpa.repository.JpaRepository<Entity120, Long> {
    fun findByField1(field1: String): List<Entity120>
    fun findByField3GreaterThan(value: Int): List<Entity120>
}

@Service
@Transactional
class Service120(private val repo: Entity120Repository) {
    fun findAll(): List<Entity120> = repo.findAll()
    fun findByName(name: String): List<Entity120> = repo.findByField1(name)
    fun save(entity: Entity120): Entity120 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity120>): List<Entity120> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
