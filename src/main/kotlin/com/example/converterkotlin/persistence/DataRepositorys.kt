package com.example.converterkotlin.persistence

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FileRepository : JpaRepository<File, Integer> {

    @Transactional
    @Modifying
    @Query("update files f set f.name = :name where f.id = :id")
    fun updateFile(@Param(value = "name") name: String, @Param(value = "id") id: Int)
    fun findById(id: Int): Optional<File>
}

@Repository
interface PathRepository : JpaRepository<Path, Integer> {

    @Transactional
    @Modifying
    @Query("update paths p set p.path = :path where p.name = :name")
    fun updatePath(@Param(value = "path") path: String, @Param(value = "name") name: String)

    @Modifying
    @Query("select p from paths p where p.name = :name")
    fun findByName(@Param(value = "name") name: String): Optional<Path>
}

@Repository
interface HistoryRepository : JpaRepository<History, Integer> {

    @Transactional
    @Modifying
    @Query("update history h set h.timestamp = :timestamp where h.id = :id")
    fun updateHistory(@Param(value = "timestamp") timestamp: String, @Param(value = "id") id: Int)
    fun findById(id: Int): Optional<History>

}
