package com.maxwell.kotlinroleplay.entities

class Enemy(name:String,
            hp:Int,
            minAtq:Int,
            maxAtq:Int,
            minDef:Int,
            maxDef:Int,
            coins:Int) : Entity(name, hp, minAtq, maxAtq, minDef, maxDef, coins)