package com.example.converterkotlin.configuration

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import org.springframework.context.annotation.Configuration

@Configuration
class CustomPhysicalNamingStrategy : PhysicalNamingStrategyStandardImpl() {
    override fun toPhysicalTableName(name: Identifier, context: JdbcEnvironment): Identifier {
        val convertedName = super.toPhysicalTableName(name, context)
        return convertedName
    }
}