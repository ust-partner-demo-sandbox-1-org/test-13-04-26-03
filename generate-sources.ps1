$baseDir = "app\src\main\kotlin\com\example\generated"

for ($i = 1; $i -le 1000; $i++) {
    $dir = "$baseDir\module$([math]::Floor($i/20))"
    New-Item -ItemType Directory -Force -Path $dir | Out-Null
    
    $content = @"
package com.example.generated.module$([math]::Floor($i/20))

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*
import org.springframework.web.bind.annotation.*

@Entity
@Table(name = "entity_$i")
data class Entity$i(
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

interface Entity${i}Repository : org.springframework.data.jpa.repository.JpaRepository<Entity$i, Long> {
    fun findByField1(field1: String): List<Entity$i>
    fun findByField3GreaterThan(value: Int): List<Entity$i>
    fun findByField4(active: Boolean): List<Entity$i>
    fun findByField1ContainingIgnoreCase(search: String): List<Entity$i>
}

@Service
@Transactional
class Service$i(private val repo: Entity${i}Repository) {
    fun findAll(): List<Entity$i> = repo.findAll()
    fun findByName(name: String): List<Entity$i> = repo.findByField1(name)
    fun findActive(): List<Entity$i> = repo.findByField4(true)
    fun search(query: String): List<Entity$i> = repo.findByField1ContainingIgnoreCase(query)
    fun save(entity: Entity$i): Entity$i = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity$i>): List<Entity$i> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
    fun transform(items: List<Entity$i>): Map<String, List<Entity$i>> {
        return items.groupBy { it.field1 }
            .mapValues { (_, v) -> v.sortedByDescending { it.field8 } }
    }
    fun validate(entity: Entity$i): Boolean {
        return entity.field1.isNotBlank() && entity.field3 >= 0 && entity.field6 > 0.0
    }
}

@RestController
@RequestMapping("/api/v1/entity$i")
class Controller$i(private val service: Service$i) {
    @GetMapping
    fun getAll() = service.findAll()
    @GetMapping("/search")
    fun search(@RequestParam q: String) = service.search(q)
    @GetMapping("/active")
    fun getActive() = service.findActive()
    @PostMapping
    fun create(@RequestBody entity: Entity$i) = service.save(entity)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
"@
    Set-Content -Path "$dir\Entity$i.kt" -Value $content
}
Write-Host "Generated 1000 Kotlin files"