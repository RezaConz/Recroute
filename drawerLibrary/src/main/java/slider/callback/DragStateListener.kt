package com.example.drawerlibrary.slider.callback


/**
 * Created by TrooTech solution on 26.08.2022.
 */
interface DragStateListener {
    fun onDragStart()
    fun onDragEnd(isMenuOpened: Boolean)
}