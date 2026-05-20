package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_921")
data class Entity921(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity921Repository : org.springframework.data.jpa.repository.JpaRepository<Entity921, Long> {
    fun findByField1(field1: String): List<Entity921>
    fun findByField3GreaterThan(value: Int): List<Entity921>
}

@Service
@Transactional
class Service921(private val repo: Entity921Repository) {
    fun findAll(): List<Entity921> = repo.findAll()
    fun findByName(name: String): List<Entity921> = repo.findByField1(name)
    fun save(entity: Entity921): Entity921 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity921>): List<Entity921> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
