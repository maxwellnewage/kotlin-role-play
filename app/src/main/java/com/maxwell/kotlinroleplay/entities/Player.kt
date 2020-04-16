package com.maxwell.kotlinroleplay.entities

import kotlin.random.Random

class Player(
    name: String,
    avatar: Int,
    coins: Int = 10,
    hp: Int = 100,
    minAtq: Int = 2,
    maxAtq: Int = 5,
    minDef: Int = 2,
    maxDef: Int = 4) : Fighter(name, avatar, Type.PLAYER, coins, hp, minAtq, maxAtq, minDef, maxDef)