package ru.skillbranch.skillarticles.ui.custom.behaviours

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.math.MathUtils
import androidx.core.view.ViewCompat
import ru.skillbranch.skillarticles.ui.custom.Bottombar

class BottomBarBehaviour(): CoordinatorLayout.Behavior<Bottombar>() {

    constructor(context: Context, attributeSet: AttributeSet):this()

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: Bottombar,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: Bottombar,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
        child.translationY = MathUtils.clamp(child.translationY + dy, 0f, child.height.toFloat())
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }

}