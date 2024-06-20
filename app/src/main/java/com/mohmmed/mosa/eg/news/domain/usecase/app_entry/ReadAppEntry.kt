package com.mohmmed.mosa.eg.news.domain.usecase.app_entry

import com.mohmmed.mosa.eg.news.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManger
) {
    operator fun invoke(): Flow<Boolean>{
        return localUserManger.readAppEntry()
    } 
}