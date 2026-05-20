$baseDir = "app\src\main\kotlin\com\example\generated"

for ($i = 1; $i -le 1000; $i++) {
    $dir = "$baseDir\module$([math]::Floor($i/20))"
    New-Item -ItemType Directory -Force -Path $dir | Out-Null
    
    $content = @"
package com.example.generated.module$([math]::Floor($i/20))

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

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
    val field5: String? = null
)

interface Entity${i}Repository : org.springframework.data.jpa.repository.JpaRepository<Entity$i, Long> {
    fun findByField1(field1: String): List<Entity$i>
    fun findByField3GreaterThan(value: Int): List<Entity$i>
}

@Service
@Transactional
class Service$i(private val repo: Entity${i}Repository) {
    fun findAll(): List<Entity$i> = repo.findAll()
    fun findByName(name: String): List<Entity$i> = repo.findByField1(name)
    fun save(entity: Entity$i): Entity$i = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity$i>): List<Entity$i> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
"@
    Set-Content -Path "$dir\Entity$i.kt" -Value $content
}
Write-Host "Generated 300 Kotlin files"