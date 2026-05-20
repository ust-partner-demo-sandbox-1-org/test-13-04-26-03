package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_288")
data class Entity288(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity288Repository : org.springframework.data.jpa.repository.JpaRepository<Entity288, Long> {
    fun findByField1(field1: String): List<Entity288>
    fun findByField3GreaterThan(value: Int): List<Entity288>
}

@Service
@Transactional
class Service288(private val repo: Entity288Repository) {
    fun findAll(): List<Entity288> = repo.findAll()
    fun findByName(name: String): List<Entity288> = repo.findByField1(name)
    fun save(entity: Entity288): Entity288 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity288>): List<Entity288> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
