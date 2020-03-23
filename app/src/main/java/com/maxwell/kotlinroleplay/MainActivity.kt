package com.maxwell.kotlinroleplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.maxwell.kotlinroleplay.engine.Battle
import com.maxwell.kotlinroleplay.entities.Enemy
import com.maxwell.kotlinroleplay.entities.Player
import com.maxwell.kotlinroleplay.entities.Type
import com.maxwell.kotlinroleplay.events.OnBattleEvents
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , OnBattleEvents {
    lateinit var battle:Battle
    lateinit var hero:Player
    lateinit var slime:Enemy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hero = Player("Max")
        slime = Enemy("Slime", 10, 5,10, 1, 2, 15)

        tvHeroName.text = "Hero name: ${hero.name}"
        tvEnemyName.text = "Enemy name: ${slime.name}"

        tvHeroHP.text = "Hero HP: ${hero.hp}"
        tvEnemyHP.text = "Enemy HP: ${slime.hp}"

        battle = Battle(hero, slime, this)

        btPlayerAtq.setOnClickListener {
            battle.attack(Type.PLAYER)
        }

        btEnemyAtq.setOnClickListener {
            battle.attack(Type.ENEMY)
        }
    }

    override fun onDamage(entityType: Type, damage: Int) {
        if(entityType == Type.PLAYER){
            Toast.makeText(this, "${hero.name} damage ${slime.name} by $damage", Toast.LENGTH_SHORT).show()
            tvEnemyHP.text = "Enemy HP: ${slime.hp}"
        } else {
            Toast.makeText(this, "${slime.name} damage ${hero.name} by $damage", Toast.LENGTH_SHORT).show()
            tvHeroHP.text = "Hero HP: ${hero.hp}"
        }
    }

    override fun onResist(entityType: Type) {
        if(entityType == Type.PLAYER){
            Toast.makeText(this, "${hero.name} resist the attack of ${slime.name}", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "${slime.name} resist the attack of ${hero.name}", Toast.LENGTH_SHORT).show()
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
