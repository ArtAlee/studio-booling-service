package com.artalee.studio.database

import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement


@Configuration
@EnableJpaRepositories(basePackages = ["com.artalee.studio.database"])
@EnableTransactionManagement
class DatabaseConfig {

    @Bean
    fun entityManagerFactory(): EntityManagerFactory {
        return Persistence.createEntityManagerFactory("StudioPersistenceUnit")
    }
}

