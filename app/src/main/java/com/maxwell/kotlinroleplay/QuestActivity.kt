package com.maxwell.kotlinroleplay

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import com.maxwell.kotlinroleplay.entities.Enemy
import com.maxwell.kotlinroleplay.quest.Quest
import com.maxwell.kotlinroleplay.utils.Utils
import kotlinx.android.synthetic.main.activity_quest.*

class QuestActivity : AppCompatActivity() {
    private var quests: ArrayList<Quest>? = null
    private val BATTLE_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)

        quests = Utils().getQuestsFromJson(this)

        runQuest(0)
    }

    private fun runQuest(questId: Int) {
        llQuestChoicesContainer.removeAllViews()

        if (questId == -1) {
            tvQuestText.text = getString(R.string.gameover)
            return
        }

        val currentQuest = quests!![questId]

        if(currentQuest.choices == null){
            val battleIntent = Intent(this, BattleActivity::class.java)
            battleIntent.putExtra("enemyId", currentQuest.enemyId)
            battleIntent.putExtra("choiceId", currentQuest.choiceId)
            startActivityForResult(battleIntent, BATTLE_CODE)
            return
        }

        tvQuestText.text = currentQuest.text

        for (choice in currentQuest.choices) {
            val button = LayoutInflater.from(this)
                .inflate(R.layout.button_choice, llQuestChoicesContainer, false)
                    as Button

            button.id = choice.id
            button.text = choice.text
            button.setOnClickListener {
                runQuest(choice.id)
            }

            llQuestChoicesContainer.addView(button)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == BATTLE_CODE && resultCode == Activity.RESULT_OK){
            runQuest(data!!.getIntExtra("choiceId", 0))
        }
    }
}
