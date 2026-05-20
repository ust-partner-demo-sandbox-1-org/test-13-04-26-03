package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_674")
data class Entity674(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity674Repository : org.springframework.data.jpa.repository.JpaRepository<Entity674, Long> {
    fun findByField1(field1: String): List<Entity674>
    fun findByField3GreaterThan(value: Int): List<Entity674>
}

@Service
@Transactional
class Service674(private val repo: Entity674Repository) {
    fun findAll(): List<Entity674> = repo.findAll()
    fun findByName(name: String): List<Entity674> = repo.findByField1(name)
    fun save(entity: Entity674): Entity674 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity674>): List<Entity674> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
