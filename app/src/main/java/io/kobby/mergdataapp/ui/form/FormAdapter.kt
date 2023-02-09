package io.kobby.mergdataapp.ui.form

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.kobby.mergdataapp.data.api.model.Question
import io.kobby.mergdataapp.databinding.ItemQuestionEditTextBinding
import io.ktor.server.routing.RoutingPath.Companion.root


class FormAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Question, FormAdapter.FormAdapterViewHolder>(
        DiffCallback()
    ) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FormAdapterViewHolder {
        val binding = ItemQuestionEditTextBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FormAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FormAdapterViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }


    inner class FormAdapterViewHolder(private val binding: ItemQuestionEditTextBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val nonConsentingHousehold = getItem(position)
//                        listener.onItemClick(nonConsentingHousehold)
                    }
                }
            }
        }

        fun bind(question: Question) {
            binding.apply {
                questionView.setQuestion(question.title)

            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(nonConsentingHousehold: Question)

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