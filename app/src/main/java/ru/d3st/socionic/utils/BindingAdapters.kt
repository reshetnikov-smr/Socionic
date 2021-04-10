package ru.d3st.socionic.utils

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter


//set visible view
@BindingAdapter("visibleGone")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("android:src")
fun setImageUri(view: ImageView, imageUri: String?) {
    if (imageUri == null) {
        view.setImageURI(null)
    } else {
        view.setImageURI(Uri.parse(imageUri))
    }
}

@BindingAdapter("android:src")
fun setImageUri(view: ImageView, imageUri: Uri?) {
    view.setImageURI(imageUri)
}

@BindingAdapter("android:src")
fun setImageDrawable(view: ImageView, drawable: Drawable?) {
    view.setImageDrawable(drawable)
}

@BindingAdapter("android:src")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

//set Number Question on Question Fragment
@BindingAdapter("setNumQuestion")
fun TextView.setNumberQuestion(item: Int) {
    text = item.plus(1).toString()
}

//set data to progress bar  Question Fragment
@BindingAdapter("setDataProgress")
fun ProgressBar.setProgress(count: Int) {
    progress = (count*5)
}

@BindingAdapter("setPersonDescription")
fun TextView.formatDescription(item: String){
    text = "\t".plus(item)
}



