package com.example.belajar

import android.view.ViewGroup


public abstract class DrawerItem<T : DrawerAdapter.ViewHolder?> {



    abstract fun createViewHolder(parent: ViewGroup?): T
    abstract fun bindViewHolder(holder: T)


    var isSelectChecked:Boolean = false
    /*
    * This function through drawer item select and unselected managed.
    * Default selected false means no any item select.
    * */
    fun setChecked(isChecked: Boolean?): DrawerItem<T> {
        this.isSelectChecked = isChecked!!
        return this
    }

    fun  isChecked(): Boolean{
        return isSelectChecked
    }


    fun  isSelectable():Boolean{
        return true
    }


}