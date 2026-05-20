package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_384")
data class Entity384(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity384Repository : org.springframework.data.jpa.repository.JpaRepository<Entity384, Long> {
    fun findByField1(field1: String): List<Entity384>
    fun findByField3GreaterThan(value: Int): List<Entity384>
}

@Service
@Transactional
class Service384(private val repo: Entity384Repository) {
    fun findAll(): List<Entity384> = repo.findAll()
    fun findByName(name: String): List<Entity384> = repo.findByField1(name)
    fun save(entity: Entity384): Entity384 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity384>): List<Entity384> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
