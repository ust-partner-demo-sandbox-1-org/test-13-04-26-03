package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_823")
data class Entity823(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity823Repository : org.springframework.data.jpa.repository.JpaRepository<Entity823, Long> {
    fun findByField1(field1: String): List<Entity823>
    fun findByField3GreaterThan(value: Int): List<Entity823>
}

@Service
@Transactional
class Service823(private val repo: Entity823Repository) {
    fun findAll(): List<Entity823> = repo.findAll()
    fun findByName(name: String): List<Entity823> = repo.findByField1(name)
    fun save(entity: Entity823): Entity823 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity823>): List<Entity823> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
