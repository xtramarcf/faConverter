package com.example.converterkotlin.persistence.app

import org.springframework.data.jpa.repository.JpaRepository

interface AppRepository : JpaRepository<App, Long> {
}