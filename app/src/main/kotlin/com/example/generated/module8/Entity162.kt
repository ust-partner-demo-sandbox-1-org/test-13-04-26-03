package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_162")
data class Entity162(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity162Repository : org.springframework.data.jpa.repository.JpaRepository<Entity162, Long> {
    fun findByField1(field1: String): List<Entity162>
    fun findByField3GreaterThan(value: Int): List<Entity162>
}

@Service
@Transactional
class Service162(private val repo: Entity162Repository) {
    fun findAll(): List<Entity162> = repo.findAll()
    fun findByName(name: String): List<Entity162> = repo.findByField1(name)
    fun save(entity: Entity162): Entity162 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity162>): List<Entity162> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
