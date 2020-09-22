package com.data.data_cloud.mapper

import com.core.mapper.IMapper
import com.data.data_cloud.response.PreviewResponse
import com.data.data_model.PreviewData

class ResponseMapper : IMapper<PreviewResponse, PreviewData> {

    override fun transform(data: PreviewResponse): PreviewData {
        return PreviewData(
            name = data.name,
            description = data.description,
            image = data.image
        )
    }
}