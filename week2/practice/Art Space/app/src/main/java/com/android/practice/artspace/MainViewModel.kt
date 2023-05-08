package com.android.practice.artspace

import androidx.lifecycle.ViewModel
import com.android.practice.artspace.data.model.Quotation

class MainViewModel : ViewModel() {
    private val quotations: List<Quotation> = listOf(
        Quotation(
            R.drawable.img_bill_gates,
            "Bill Gates",
            "To win big, sometimes you need to take big risks."
        ),
        Quotation(
            R.drawable.img_einstein, "Albert Einstein",
            "Life is like riding a bicycle.\nTo keep your balance, you must keep moving."
        ),
        Quotation(
            R.drawable.img_edison,
            "Thomas Edison",
            "What you are will show in what you do"
        )
    )

    fun getQuotations(): List<Quotation> = quotations
}