package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_299")
data class Entity299(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity299Repository : org.springframework.data.jpa.repository.JpaRepository<Entity299, Long> {
    fun findByField1(field1: String): List<Entity299>
    fun findByField3GreaterThan(value: Int): List<Entity299>
}

@Service
@Transactional
class Service299(private val repo: Entity299Repository) {
    fun findAll(): List<Entity299> = repo.findAll()
    fun findByName(name: String): List<Entity299> = repo.findByField1(name)
    fun save(entity: Entity299): Entity299 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity299>): List<Entity299> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
