package com.maxwell.kotlinroleplay.entities

import kotlin.random.Random

class Player(
    name: String,
    hp: Int = 100,
    minAtq: Int = 1,
    maxAtq: Int = 2,
    minDef: Int = 1,
    maxDef: Int = 2,
    coins: Int = 10) : Entity(name, hp, minAtq, maxAtq, minDef, maxDef, coins)