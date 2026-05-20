package com.example.generated.module28

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_575")
data class Entity575(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity575Repository : org.springframework.data.jpa.repository.JpaRepository<Entity575, Long> {
    fun findByField1(field1: String): List<Entity575>
    fun findByField3GreaterThan(value: Int): List<Entity575>
}

@Service
@Transactional
class Service575(private val repo: Entity575Repository) {
    fun findAll(): List<Entity575> = repo.findAll()
    fun findByName(name: String): List<Entity575> = repo.findByField1(name)
    fun save(entity: Entity575): Entity575 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity575>): List<Entity575> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
