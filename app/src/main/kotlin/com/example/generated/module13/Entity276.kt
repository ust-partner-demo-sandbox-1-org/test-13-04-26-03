package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_276")
data class Entity276(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity276Repository : org.springframework.data.jpa.repository.JpaRepository<Entity276, Long> {
    fun findByField1(field1: String): List<Entity276>
    fun findByField3GreaterThan(value: Int): List<Entity276>
}

@Service
@Transactional
class Service276(private val repo: Entity276Repository) {
    fun findAll(): List<Entity276> = repo.findAll()
    fun findByName(name: String): List<Entity276> = repo.findByField1(name)
    fun save(entity: Entity276): Entity276 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity276>): List<Entity276> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
