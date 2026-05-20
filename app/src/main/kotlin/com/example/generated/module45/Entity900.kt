package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*
import org.springframework.web.bind.annotation.*

@Entity
@Table(name = "entity_900")
data class Entity900(
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

interface Entity900Repository : org.springframework.data.jpa.repository.JpaRepository<Entity900, Long> {
    fun findByField1(field1: String): List<Entity900>
    fun findByField3GreaterThan(value: Int): List<Entity900>
    fun findByField4(active: Boolean): List<Entity900>
    fun findByField1ContainingIgnoreCase(search: String): List<Entity900>
}

@Service
@Transactional
class Service900(private val repo: Entity900Repository) {
    fun findAll(): List<Entity900> = repo.findAll()
    fun findByName(name: String): List<Entity900> = repo.findByField1(name)
    fun findActive(): List<Entity900> = repo.findByField4(true)
    fun search(query: String): List<Entity900> = repo.findByField1ContainingIgnoreCase(query)
    fun save(entity: Entity900): Entity900 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity900>): List<Entity900> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
    fun transform(items: List<Entity900>): Map<String, List<Entity900>> {
        return items.groupBy { it.field1 }
            .mapValues { (_, v) -> v.sortedByDescending { it.field8 } }
    }
    fun validate(entity: Entity900): Boolean {
        return entity.field1.isNotBlank() && entity.field3 >= 0 && entity.field6 > 0.0
    }
}

@RestController
@RequestMapping("/api/v1/entity900")
class Controller900(private val service: Service900) {
    @GetMapping
    fun getAll() = service.findAll()
    @GetMapping("/search")
    fun search(@RequestParam q: String) = service.search(q)
    @GetMapping("/active")
    fun getActive() = service.findActive()
    @PostMapping
    fun create(@RequestBody entity: Entity900) = service.save(entity)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
