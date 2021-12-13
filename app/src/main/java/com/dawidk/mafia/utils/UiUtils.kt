package com.dawidk.mafia.utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun EditText.hideKeyboardOnAction(context: Context, action: Int) {
    this.setOnEditorActionListener { v, actionId, _ ->
        if (actionId == action) {
            v.clearFocus()
            val inputMethodManager =
                context.getSystemService(Context.INPUT_METHOD_SERVICE)
                        as? InputMethodManager
            inputMethodManager?.hideSoftInputFromWindow(v.windowToken, 0)
            true
        } else false
    }
}