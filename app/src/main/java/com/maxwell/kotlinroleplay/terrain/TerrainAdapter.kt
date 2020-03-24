package com.maxwell.kotlinroleplay.terrain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maxwell.kotlinroleplay.R

class TerrainAdapter (val tiles: List<Tile>) : RecyclerView.Adapter<TerrainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TerrainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_terrain_tile, parent, false)

        return TerrainViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tiles.size
    }

    override fun onBindViewHolder(holder: TerrainViewHolder, position: Int) {
        holder.ivTerrainTile?.setImageResource(tiles[position].entity.avatar)
    }
}