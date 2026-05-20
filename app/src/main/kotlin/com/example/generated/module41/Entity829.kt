package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_829")
data class Entity829(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity829Repository : org.springframework.data.jpa.repository.JpaRepository<Entity829, Long> {
    fun findByField1(field1: String): List<Entity829>
    fun findByField3GreaterThan(value: Int): List<Entity829>
}

@Service
@Transactional
class Service829(private val repo: Entity829Repository) {
    fun findAll(): List<Entity829> = repo.findAll()
    fun findByName(name: String): List<Entity829> = repo.findByField1(name)
    fun save(entity: Entity829): Entity829 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity829>): List<Entity829> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
