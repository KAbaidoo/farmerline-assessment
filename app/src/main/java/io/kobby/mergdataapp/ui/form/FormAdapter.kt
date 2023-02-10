package io.kobby.mergdataapp.ui.form

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.kobby.mergdataapp.data.api.model.Question
import io.kobby.mergdataapp.databinding.ItemQuestionEditTextBinding
import io.kobby.mergdataapp.databinding.ItemQuestionRadioButtonsBinding
import io.kobby.mergdataapp.util.FormType


class FormAdapter :
    ListAdapter<Question, RecyclerView.ViewHolder>(
        DiffCallback()
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):RecyclerView.ViewHolder =
        if (viewType == 0)
            {
                val binding = ItemQuestionEditTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                 FormAdapterViewHolderEditText(binding)
            }
            else {
                val binding = ItemQuestionRadioButtonsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                 FormAdapterViewHolderRadioButtons(binding)
            }


    override fun getItemViewType(position: Int): Int = if(getItem(position).form_type == FormType.EDIT_TEXT.name)
        0
    else
        2





    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)
        when(holder.itemViewType){
            0 ->{ val editTextHolder = holder as FormAdapterViewHolderEditText
                editTextHolder.bind(currentItem)
            }
            else->{
                val radioButtonsHolder = holder as FormAdapterViewHolderRadioButtons
                radioButtonsHolder.bind(currentItem)
            }
        }

    }


    inner class FormAdapterViewHolderEditText(private val binding: ItemQuestionEditTextBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(question: Question) {
            binding.apply {
                questionView.apply {
                    setQuestion(question.title)
                    setDefaultAnswer(question.defaultAnswer)
                    setQuestionNumber(question.question_number)
                }

            }
        }
    }

    inner class FormAdapterViewHolderRadioButtons(private val binding: ItemQuestionRadioButtonsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: Question) {
            binding.apply {
                questionView.apply {
                    setQuestion(question.title)
                    setQuestionNumber(question.question_number)
                    question.radio_button_option?.let { setRadioButtons(it) }
                }

            }
        }
    }



    class DiffCallback : DiffUtil.ItemCallback<Question>() {
        override fun areItemsTheSame(oldItem: Question, newItem: Question) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Question,
            newItem: Question
        ) = oldItem == newItem
    }
}