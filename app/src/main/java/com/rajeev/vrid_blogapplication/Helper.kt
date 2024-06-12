package com.rajeev.vrid_blogapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun FragmentManager.commitFragment(
    fragmentTagPair: Pair<Fragment, String>
) {
//    this.beginTransaction().customSlideRightLeftAnimation().addToBackStack(null)
//        .add(android.R.id.content, fragmentTagPair.first, fragmentTagPair.second).commit()
}

//fun FragmentTransaction.customSlideRightLeftAnimation() = this.setCustomAnimations(
//    R.anim.slide_in_right, R.anim.slide_out_right,
//    R.anim.slide_in_right, R.anim.slide_out_right
//)

//fun FragmentTransaction.customSlideUpDownAnimation() = this.setCustomAnimations(
//    R.anim.slide_in_down, R.anim.slide_out_down,
//    R.anim.slide_in_down, R.anim.slide_out_down
//)