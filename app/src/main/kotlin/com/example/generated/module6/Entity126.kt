package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_126")
data class Entity126(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity126Repository : org.springframework.data.jpa.repository.JpaRepository<Entity126, Long> {
    fun findByField1(field1: String): List<Entity126>
    fun findByField3GreaterThan(value: Int): List<Entity126>
}

@Service
@Transactional
class Service126(private val repo: Entity126Repository) {
    fun findAll(): List<Entity126> = repo.findAll()
    fun findByName(name: String): List<Entity126> = repo.findByField1(name)
    fun save(entity: Entity126): Entity126 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity126>): List<Entity126> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
