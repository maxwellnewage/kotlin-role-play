package com.maxwell.kotlinroleplay.terrain

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.maxwell.kotlinroleplay.R

class TerrainViewHolder (view: View) : RecyclerView.ViewHolder(view){
    var ivTerrainTile : ImageView? = null

    init {
        ivTerrainTile = itemView.findViewById(R.id.ivTerrainTile)
    }
}