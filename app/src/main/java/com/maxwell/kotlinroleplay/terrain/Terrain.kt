package com.maxwell.kotlinroleplay.terrain

import android.content.Context
import android.widget.GridLayout
import android.widget.ImageView
import com.maxwell.kotlinroleplay.R
import com.maxwell.kotlinroleplay.entities.Empty
import com.maxwell.kotlinroleplay.entities.Enemy

class Terrain(){
    fun generate() : ArrayList<Tile> {
        val tiles = ArrayList<Tile>()

        val floor = Empty("Floor", R.drawable.ic_empty_terrain)
        val floorTile = Tile(floor)

        for(i in 1..15){
            tiles.add(floorTile)
        }

        return tiles
    }
}