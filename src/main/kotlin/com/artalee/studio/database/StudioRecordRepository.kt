package com.artalee.studio.database

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudioRecordRepository : JpaRepository<StudioRecord, Long> {

}
