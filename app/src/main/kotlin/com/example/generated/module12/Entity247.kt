package com.example.generated.module12

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*
import org.springframework.web.bind.annotation.*

@Entity
@Table(name = "entity_247")
data class Entity247(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null,
    val field6: Double = 0.0,
    val field7: String? = null,
    val field8: Long = 0,
    val field9: Boolean = true,
    @Column(columnDefinition = "TEXT")
    val field10: String? = null
)

interface Entity247Repository : org.springframework.data.jpa.repository.JpaRepository<Entity247, Long> {
    fun findByField1(field1: String): List<Entity247>
    fun findByField3GreaterThan(value: Int): List<Entity247>
    fun findByField4(active: Boolean): List<Entity247>
    fun findByField1ContainingIgnoreCase(search: String): List<Entity247>
}

@Service
@Transactional
class Service247(private val repo: Entity247Repository) {
    fun findAll(): List<Entity247> = repo.findAll()
    fun findByName(name: String): List<Entity247> = repo.findByField1(name)
    fun findActive(): List<Entity247> = repo.findByField4(true)
    fun search(query: String): List<Entity247> = repo.findByField1ContainingIgnoreCase(query)
    fun save(entity: Entity247): Entity247 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity247>): List<Entity247> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
    fun transform(items: List<Entity247>): Map<String, List<Entity247>> {
        return items.groupBy { it.field1 }
            .mapValues { (_, v) -> v.sortedByDescending { it.field8 } }
    }
    fun validate(entity: Entity247): Boolean {
        return entity.field1.isNotBlank() && entity.field3 >= 0 && entity.field6 > 0.0
    }
}

@RestController
@RequestMapping("/api/v1/entity247")
class Controller247(private val service: Service247) {
    @GetMapping
    fun getAll() = service.findAll()
    @GetMapping("/search")
    fun search(@RequestParam q: String) = service.search(q)
    @GetMapping("/active")
    fun getActive() = service.findActive()
    @PostMapping
    fun create(@RequestBody entity: Entity247) = service.save(entity)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
