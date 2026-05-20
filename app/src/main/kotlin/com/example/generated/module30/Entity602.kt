package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_602")
data class Entity602(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity602Repository : org.springframework.data.jpa.repository.JpaRepository<Entity602, Long> {
    fun findByField1(field1: String): List<Entity602>
    fun findByField3GreaterThan(value: Int): List<Entity602>
}

@Service
@Transactional
class Service602(private val repo: Entity602Repository) {
    fun findAll(): List<Entity602> = repo.findAll()
    fun findByName(name: String): List<Entity602> = repo.findByField1(name)
    fun save(entity: Entity602): Entity602 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity602>): List<Entity602> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
