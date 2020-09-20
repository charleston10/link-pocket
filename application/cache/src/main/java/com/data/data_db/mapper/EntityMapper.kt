package com.data.data_db.mapper

import com.core.IMapper
import com.data.data_model.PreviewData
import com.data.data_db.entity.PreviewEntity

class EntityMapper : IMapper<PreviewEntity, PreviewData> {

    override fun transform(data: PreviewEntity): PreviewData {
        return PreviewData(
            name = data.name,
            description = data.description,
            image = data.image
        )
    }
}