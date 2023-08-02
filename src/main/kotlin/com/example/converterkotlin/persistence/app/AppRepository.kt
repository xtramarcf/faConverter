//package com.example.converterkotlin.persistence.app
//
//import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.data.jpa.repository.Query
//
//interface AppRepository : JpaRepository<App, Long> {
//
//    @Query("select u.name from files u where id = 1")
//    fun getName()
//
//}