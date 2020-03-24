package com.maxwell.kotlinroleplay.entities

abstract class Fighter (
                name: String,
                avatar: Int,
                var coins:Int,
                var hp: Int,
                var minAtq: Int,
                var maxAtq: Int,
                var minDef: Int,
                var maxDef: Int) : Entity(name, avatar)