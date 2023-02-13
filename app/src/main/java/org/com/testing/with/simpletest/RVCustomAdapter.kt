package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.com.testing.with.simpletest.databinding.CardViewItemBinding
import java.util.*

/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter : RecyclerView.Adapter<RVCustomAdapter.RVCustomViewHolder>() {

    private var items: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVCustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_view_item, parent, false)
        val binding = CardViewItemBinding.bind(view)
        return RVCustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RVCustomViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<Article>) {
        this.items = Collections.unmodifiableList(items)
    }

    class RVCustomViewHolder(
        private val binding: CardViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: Article) {
            binding.mTextViewTitle.text = model.title
            binding.mTextViewContent.text = model.content
            Picasso.get()
                .load(model.imageURL)
                .fit()
                .centerCrop()
                .into(binding.mImageViewCardViewItem)
        }
    }
}