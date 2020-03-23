package com.maxwell.kotlinroleplay.engine

import com.maxwell.kotlinroleplay.entities.Enemy
import com.maxwell.kotlinroleplay.entities.Player
import com.maxwell.kotlinroleplay.entities.Type
import com.maxwell.kotlinroleplay.events.OnBattleEvents
import kotlin.random.Random

class Battle (val player: Player, val enemy: Enemy, val onBattleEvents: OnBattleEvents){

    fun attack(entityType: Type) {
        val playerAtq = Random.nextInt(player.minAtq, player.maxAtq)
        val playerDef = Random.nextInt(player.minDef, player.maxDef)

        val enemyAtq = Random.nextInt(enemy.minAtq, enemy.maxAtq)
        val enemyDef = Random.nextInt(enemy.minDef, enemy.maxDef)

        if(entityType == Type.PLAYER){
            val playerAtqResult = playerAtq - enemyDef

            if(playerAtqResult > 0){
                enemy.hp -= playerAtqResult

                if(enemy.hp > 0){
                    onBattleEvents.onDamage(Type.PLAYER, playerAtqResult)
                } else {
                    onBattleEvents.onDeath(Type.ENEMY)
                }
            } else {
                onBattleEvents.onResist(Type.ENEMY)
            }

        } else if (entityType == Type.ENEMY) {
            val enemyAtqResult = enemyAtq - playerDef

            if(enemyAtqResult > 0){
                player.hp -= enemyAtqResult

                if(player.hp > 0){
                    onBattleEvents.onDamage(Type.ENEMY, enemyAtqResult)
                } else {
                    onBattleEvents.onDeath(Type.PLAYER)
                }
            } else {
                onBattleEvents.onResist(Type.PLAYER)
            }
        }
    }
}