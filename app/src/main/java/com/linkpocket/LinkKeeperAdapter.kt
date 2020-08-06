package com.linkpocket

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card_link.view.*

class LinkKeeperAdapter : ItemViewBuilder<Preview>() {

    override val layout: Int = R.layout.item_card_link

    override fun View.onBind(position: Int) {
        val item = collection.elementAt(position)
        title.text = item.name
        description.text = item.description

        Glide.with(this)
            .load(item.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(photo);
    }
}