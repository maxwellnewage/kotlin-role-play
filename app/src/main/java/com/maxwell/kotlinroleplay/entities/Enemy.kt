package com.maxwell.kotlinroleplay.entities

class Enemy(name: String,
            avatar: Int,
            coins:Int,
            hp:Int,
            minAtq:Int,
            maxAtq:Int,
            minDef:Int,
            maxDef:Int) : Fighter(name, avatar, hp, minAtq, maxAtq, minDef, maxDef, coins)