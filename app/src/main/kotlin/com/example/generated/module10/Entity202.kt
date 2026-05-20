package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_202")
data class Entity202(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity202Repository : org.springframework.data.jpa.repository.JpaRepository<Entity202, Long> {
    fun findByField1(field1: String): List<Entity202>
    fun findByField3GreaterThan(value: Int): List<Entity202>
}

@Service
@Transactional
class Service202(private val repo: Entity202Repository) {
    fun findAll(): List<Entity202> = repo.findAll()
    fun findByName(name: String): List<Entity202> = repo.findByField1(name)
    fun save(entity: Entity202): Entity202 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity202>): List<Entity202> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
