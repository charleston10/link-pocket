package com.data.data_db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.data.data_db.entity.PreviewEntity
import io.reactivex.Observable

@Dao
interface IPreviewDao {

    @Insert
    fun addAll(vararg previews: PreviewEntity)

    @Query("SELECT * FROM preview")
    fun getAll(): Observable<List<PreviewEntity>>
}