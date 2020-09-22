package com.data.mapper

import com.core.mapper.IMapper
import com.data.data_model.PreviewData
import com.domain.model.Preview

class ModelMapper : IMapper<PreviewData, Preview> {

    override fun transform(data: PreviewData): Preview {
        return Preview(
            name = data.name,
            description = data.description,
            image = data.image
        )
    }
}