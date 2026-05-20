package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_995")
data class Entity995(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity995Repository : org.springframework.data.jpa.repository.JpaRepository<Entity995, Long> {
    fun findByField1(field1: String): List<Entity995>
    fun findByField3GreaterThan(value: Int): List<Entity995>
}

@Service
@Transactional
class Service995(private val repo: Entity995Repository) {
    fun findAll(): List<Entity995> = repo.findAll()
    fun findByName(name: String): List<Entity995> = repo.findByField1(name)
    fun save(entity: Entity995): Entity995 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity995>): List<Entity995> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
