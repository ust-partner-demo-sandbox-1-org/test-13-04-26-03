package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_285")
data class Entity285(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity285Repository : org.springframework.data.jpa.repository.JpaRepository<Entity285, Long> {
    fun findByField1(field1: String): List<Entity285>
    fun findByField3GreaterThan(value: Int): List<Entity285>
}

@Service
@Transactional
class Service285(private val repo: Entity285Repository) {
    fun findAll(): List<Entity285> = repo.findAll()
    fun findByName(name: String): List<Entity285> = repo.findByField1(name)
    fun save(entity: Entity285): Entity285 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity285>): List<Entity285> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
