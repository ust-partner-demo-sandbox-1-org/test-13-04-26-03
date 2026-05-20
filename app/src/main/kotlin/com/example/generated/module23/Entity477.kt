package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*
import org.springframework.web.bind.annotation.*

@Entity
@Table(name = "entity_477")
data class Entity477(
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

interface Entity477Repository : org.springframework.data.jpa.repository.JpaRepository<Entity477, Long> {
    fun findByField1(field1: String): List<Entity477>
    fun findByField3GreaterThan(value: Int): List<Entity477>
    fun findByField4(active: Boolean): List<Entity477>
    fun findByField1ContainingIgnoreCase(search: String): List<Entity477>
}

@Service
@Transactional
class Service477(private val repo: Entity477Repository) {
    fun findAll(): List<Entity477> = repo.findAll()
    fun findByName(name: String): List<Entity477> = repo.findByField1(name)
    fun findActive(): List<Entity477> = repo.findByField4(true)
    fun search(query: String): List<Entity477> = repo.findByField1ContainingIgnoreCase(query)
    fun save(entity: Entity477): Entity477 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity477>): List<Entity477> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
    fun transform(items: List<Entity477>): Map<String, List<Entity477>> {
        return items.groupBy { it.field1 }
            .mapValues { (_, v) -> v.sortedByDescending { it.field8 } }
    }
    fun validate(entity: Entity477): Boolean {
        return entity.field1.isNotBlank() && entity.field3 >= 0 && entity.field6 > 0.0
    }
}

@RestController
@RequestMapping("/api/v1/entity477")
class Controller477(private val service: Service477) {
    @GetMapping
    fun getAll() = service.findAll()
    @GetMapping("/search")
    fun search(@RequestParam q: String) = service.search(q)
    @GetMapping("/active")
    fun getActive() = service.findActive()
    @PostMapping
    fun create(@RequestBody entity: Entity477) = service.save(entity)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
