package com.md.demo.misc.ext

import com.google.android.material.bottomsheet.BottomSheetBehavior

fun BottomSheetBehavior<*>.isExpanded(): Boolean {
    return state == com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
}

fun BottomSheetBehavior<*>.isHidden(): Boolean {
    return isExpanded().not()
}

fun BottomSheetBehavior<*>.expand() {
    state = com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
}

fun BottomSheetBehavior<*>.hide() {
    state = com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
}

fun BottomSheetBehavior<*>.toggle() {
    if (isHidden()) {
        expand()
    } else if (isExpanded()) {
        hide()
    }
}
