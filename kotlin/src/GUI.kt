//kotlin使用GUI界面也是调用Java的swing组件的，和Java互操作
package com.gmq.test

import javax.swing.*
import java.awt.*

fun main(){
    var frame = JFrame("kotlin GUI")
    frame.setSize(400, 400)
    frame.isVisible = true
    var button = JButton("button1")
    button.isVisible = true
    frame.layout = BorderLayout()
    frame.add(button, BorderLayout.CENTER)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}