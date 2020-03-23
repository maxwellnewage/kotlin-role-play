package com.maxwell.kotlinroleplay.events

import com.maxwell.kotlinroleplay.entities.Type

interface OnBattleEvents {
    fun onDamage(entityType:Type, damage:Int)
    fun onResist(entityType:Type)
    fun onDeath(entityType:Type)
}