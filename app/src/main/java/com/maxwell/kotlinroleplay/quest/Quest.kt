package com.maxwell.kotlinroleplay.quest

data class Quest(val id:Int, val text:String, val choices: List<Choice>, val enemyId:Int, val choiceId:Int )