package io.kobby.mergdataapp.ui.form.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

import io.kobby.mergdataapp.R
import io.kobby.mergdataapp.data.api.model.RadioButtonOption

class RadioButtonQuestion @JvmOverloads
constructor(
    private val ctx: Context,
    private val attributeSet: AttributeSet? = null,
    private val defStyleAttr: Int = 0
) : LinearLayout(ctx, attributeSet, defStyleAttr) {
    var inflater: LayoutInflater

    init {
        // get the inflater service from the android system
        inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // inflate the layout into "this" component
        inflater.inflate(R.layout.radio_button_question, this)
    }

    fun setRadioButtons(radioButtons: List<RadioButtonOption>) {
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        for (rb in radioButtons) {
            val r = RadioButton(ctx).apply {
                text = rb.name ?: ""
                id = rb.id!!
            }
            radioGroup.addView(r)
        }
    }

    fun setQuestion(question: String?){
        findViewById<TextView>(R.id.text_field_question).text =question ?: "Error: title unavailable!"
    }

    fun setQuestionNumber(setQuestionNumber: Int?) {
        findViewById<TextView>(R.id.text_view_question_number).text = setQuestionNumber.toString() ?: "0"
    }



}