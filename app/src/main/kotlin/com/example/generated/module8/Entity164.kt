package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_164")
data class Entity164(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity164Repository : org.springframework.data.jpa.repository.JpaRepository<Entity164, Long> {
    fun findByField1(field1: String): List<Entity164>
    fun findByField3GreaterThan(value: Int): List<Entity164>
}

@Service
@Transactional
class Service164(private val repo: Entity164Repository) {
    fun findAll(): List<Entity164> = repo.findAll()
    fun findByName(name: String): List<Entity164> = repo.findByField1(name)
    fun save(entity: Entity164): Entity164 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity164>): List<Entity164> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
