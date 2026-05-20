package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_914")
data class Entity914(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity914Repository : org.springframework.data.jpa.repository.JpaRepository<Entity914, Long> {
    fun findByField1(field1: String): List<Entity914>
    fun findByField3GreaterThan(value: Int): List<Entity914>
}

@Service
@Transactional
class Service914(private val repo: Entity914Repository) {
    fun findAll(): List<Entity914> = repo.findAll()
    fun findByName(name: String): List<Entity914> = repo.findByField1(name)
    fun save(entity: Entity914): Entity914 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity914>): List<Entity914> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
