package com.example.generated.module32

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_659")
data class Entity659(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity659Repository : org.springframework.data.jpa.repository.JpaRepository<Entity659, Long> {
    fun findByField1(field1: String): List<Entity659>
    fun findByField3GreaterThan(value: Int): List<Entity659>
}

@Service
@Transactional
class Service659(private val repo: Entity659Repository) {
    fun findAll(): List<Entity659> = repo.findAll()
    fun findByName(name: String): List<Entity659> = repo.findByField1(name)
    fun save(entity: Entity659): Entity659 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity659>): List<Entity659> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
