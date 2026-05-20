package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_609")
data class Entity609(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity609Repository : org.springframework.data.jpa.repository.JpaRepository<Entity609, Long> {
    fun findByField1(field1: String): List<Entity609>
    fun findByField3GreaterThan(value: Int): List<Entity609>
}

@Service
@Transactional
class Service609(private val repo: Entity609Repository) {
    fun findAll(): List<Entity609> = repo.findAll()
    fun findByName(name: String): List<Entity609> = repo.findByField1(name)
    fun save(entity: Entity609): Entity609 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity609>): List<Entity609> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
