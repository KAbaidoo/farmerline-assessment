package io.kobby.mergdataapp.ui.form

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

import com.google.android.material.textfield.TextInputLayout
import io.kobby.mergdataapp.R

class EditTextQuestion @JvmOverloads
constructor(
    private val ctx: Context,
    private val attributeSet: AttributeSet? = null,
    private val defStyleAttr: Int = 0
) : LinearLayout(ctx, attributeSet, defStyleAttr) {

    init {
        // get the inflater service from the android system
        val inflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // inflate the layout into "this" component
        inflater.inflate(R.layout.edit_text_question, this)

    }
   fun setQuestion(question: String){
       findViewById<TextView>(R.id.text_field_question).text =question
   }
    fun getAnswer (question: String): String{
       return  findViewById<TextInputLayout>(R.id.edit_text_answer).editText?.text.toString()
    }


}