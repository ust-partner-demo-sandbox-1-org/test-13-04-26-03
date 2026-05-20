package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_616")
data class Entity616(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity616Repository : org.springframework.data.jpa.repository.JpaRepository<Entity616, Long> {
    fun findByField1(field1: String): List<Entity616>
    fun findByField3GreaterThan(value: Int): List<Entity616>
}

@Service
@Transactional
class Service616(private val repo: Entity616Repository) {
    fun findAll(): List<Entity616> = repo.findAll()
    fun findByName(name: String): List<Entity616> = repo.findByField1(name)
    fun save(entity: Entity616): Entity616 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity616>): List<Entity616> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
