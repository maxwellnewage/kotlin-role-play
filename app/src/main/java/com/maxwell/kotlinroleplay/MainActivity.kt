package com.maxwell.kotlinroleplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.maxwell.kotlinroleplay.engine.Battle
import com.maxwell.kotlinroleplay.entities.Enemy
import com.maxwell.kotlinroleplay.entities.Player
import com.maxwell.kotlinroleplay.entities.Type
import com.maxwell.kotlinroleplay.events.OnBattleEvents
import com.maxwell.kotlinroleplay.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() , OnBattleEvents {
    lateinit var battle:Battle
    lateinit var hero:Player
    lateinit var enemy:Enemy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hero = Player("Max", R.drawable.ic_empty_terrain)

        val enemies = Utils().getEnemiesFromJson(this)

        enemy = enemies[Random.nextInt(0, enemies.size - 1)]

        tvHeroName.text = "Hero name: ${hero.name}"
        tvEnemyName.text = "Enemy name: ${enemy.name}"

        tvHeroHP.text = "Hero HP: ${hero.hp}"
        tvEnemyHP.text = "Enemy HP: ${enemy.hp}"

        battle = Battle(hero, enemy, this)

        btPlayerAtq.setOnClickListener {
            battle.attack(Type.PLAYER)
        }

        btEnemyAtq.setOnClickListener {
            battle.attack(Type.ENEMY)
        }
    }

    override fun onDamage(entityType: Type, damage: Int) {
        if(entityType == Type.PLAYER){
            Toast.makeText(this, "${hero.name} damage ${enemy.name} by $damage", Toast.LENGTH_SHORT).show()
            tvEnemyHP.text = "Enemy HP: ${enemy.hp}"
        } else {
            Toast.makeText(this, "${enemy.name} damage ${hero.name} by $damage", Toast.LENGTH_SHORT).show()
            tvHeroHP.text = "Hero HP: ${hero.hp}"
        }
    }

    override fun onResist(entityType: Type) {
        if(entityType == Type.PLAYER){
            Toast.makeText(this, "${hero.name} resist the attack of ${enemy.name}", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "${enemy.name} resist the attack of ${hero.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDeath(entityType: Type) {
        if(entityType == Type.PLAYER){
            Toast.makeText(this, "You loose!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show()
        }
    }
}
