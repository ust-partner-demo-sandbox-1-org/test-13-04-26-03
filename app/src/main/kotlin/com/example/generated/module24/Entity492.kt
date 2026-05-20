package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_492")
data class Entity492(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity492Repository : org.springframework.data.jpa.repository.JpaRepository<Entity492, Long> {
    fun findByField1(field1: String): List<Entity492>
    fun findByField3GreaterThan(value: Int): List<Entity492>
}

@Service
@Transactional
class Service492(private val repo: Entity492Repository) {
    fun findAll(): List<Entity492> = repo.findAll()
    fun findByName(name: String): List<Entity492> = repo.findByField1(name)
    fun save(entity: Entity492): Entity492 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity492>): List<Entity492> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
