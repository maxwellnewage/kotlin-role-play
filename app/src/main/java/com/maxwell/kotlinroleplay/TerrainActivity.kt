package com.maxwell.kotlinroleplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.maxwell.kotlinroleplay.terrain.Terrain
import com.maxwell.kotlinroleplay.terrain.TerrainAdapter
import kotlinx.android.synthetic.main.activity_terrain.*

class TerrainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terrain)

        val tiles = Terrain().generate()

        rvTerrainContainer.layoutManager = GridLayoutManager(this, 5)

        val adapter = TerrainAdapter(tiles)

        rvTerrainContainer.adapter = adapter
    }
}
