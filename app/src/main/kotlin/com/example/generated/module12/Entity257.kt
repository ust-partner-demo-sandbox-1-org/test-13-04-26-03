package com.example.generated.module12

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_257")
data class Entity257(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity257Repository : org.springframework.data.jpa.repository.JpaRepository<Entity257, Long> {
    fun findByField1(field1: String): List<Entity257>
    fun findByField3GreaterThan(value: Int): List<Entity257>
}

@Service
@Transactional
class Service257(private val repo: Entity257Repository) {
    fun findAll(): List<Entity257> = repo.findAll()
    fun findByName(name: String): List<Entity257> = repo.findByField1(name)
    fun save(entity: Entity257): Entity257 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity257>): List<Entity257> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
