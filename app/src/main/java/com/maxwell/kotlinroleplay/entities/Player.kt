package com.maxwell.kotlinroleplay.entities

import kotlin.random.Random

class Player(
    name: String,
    avatar: Int,
    coins: Int = 10,
    hp: Int = 100,
    minAtq: Int = 1,
    maxAtq: Int = 2,
    minDef: Int = 1,
    maxDef: Int = 2) : Fighter(name, avatar, Type.PLAYER, hp, minAtq, maxAtq, minDef, maxDef, coins)