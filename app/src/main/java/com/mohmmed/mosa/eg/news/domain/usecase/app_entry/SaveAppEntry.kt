package com.mohmmed.mosa.eg.news.domain.usecase.app_entry

import com.mohmmed.mosa.eg.news.domain.manger.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }
}