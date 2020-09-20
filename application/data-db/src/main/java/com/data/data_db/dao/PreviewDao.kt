package com.data.data_db.dao

import android.content.Context
import com.data.data_db.DatabaseBuilder
import com.data.data_db.entity.PreviewEntity
import io.reactivex.Observable

class PreviewDao(context: Context) : IPreviewDao {

    private val dao = DatabaseBuilder.getAppDatabase(context).previewDao()

    override fun addAll(vararg previews: PreviewEntity) {
        dao.addAll(*previews)
    }

    override fun getAll(): Observable<List<PreviewEntity>> {
        return dao.getAll()
    }
}