package com.example.generated.module34

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_691")
data class Entity691(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity691Repository : org.springframework.data.jpa.repository.JpaRepository<Entity691, Long> {
    fun findByField1(field1: String): List<Entity691>
    fun findByField3GreaterThan(value: Int): List<Entity691>
}

@Service
@Transactional
class Service691(private val repo: Entity691Repository) {
    fun findAll(): List<Entity691> = repo.findAll()
    fun findByName(name: String): List<Entity691> = repo.findByField1(name)
    fun save(entity: Entity691): Entity691 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity691>): List<Entity691> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
