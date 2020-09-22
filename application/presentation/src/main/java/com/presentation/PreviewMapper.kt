package com.presentation

import com.core.mapper.IMapper
import com.domain.model.Preview

class PreviewMapper : IMapper<Preview, PreviewModel> {

    override fun transform(data: Preview): PreviewModel {
        return PreviewModel(
            name = data.name,
            description = data.description,
            image = data.image
        )
    }
}