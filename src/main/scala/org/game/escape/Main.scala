package org.game.escape

import processing.core._
import math._
import scala.util.Random
import java.awt.Dimension
import org.game.escape.gui._
import scala.compat._

object Main extends PApplet {

  val (xWIDTH,xHEIGHT,xSCALE) = (640,320,2)

  private var test:Main = _

  def main(args: Array[String]) = {
    test = new Main
    val frame = new javax.swing.JFrame("Main")
    frame.getContentPane().add(test)
    test.init

    val size = new Dimension(xWIDTH*xSCALE,xHEIGHT*xSCALE)

    frame.pack
    frame.setVisible(true)
    frame.setResizable(false)
    frame.setPreferredSize(size)
    frame.setSize(size)
  }
}

class Main extends PApplet {

  val (xWIDTH, xHEIGHT, xSCALE) = (Main.xWIDTH*Main.xSCALE, Main.xHEIGHT*Main.xSCALE, Main.xSCALE)
  val bitmap = new Bitmap(100*xSCALE,100*xSCALE,this)

  override def setup() = {  
    size(xHEIGHT,xWIDTH)
    frameRate(60)
    background(0,0,0)
  }

  override def draw() = {
    background(0,0,0)
    for (i <- 0 to 100) {
      val x0 = (math.sin(((Platform.currentTime + i * 16) % 2000 / 2000.0 * Math.PI * 2)) * xWIDTH /  3).toInt
      val y0 = (math.cos(((Platform.currentTime + i * 16) % 2000 / 2000.0 * Math.PI * 2)) * xHEIGHT / 3).toInt
      image(bitmap.draw,(xWIDTH-bitmap.width) / 2 + x0, (xHEIGHT-bitmap.height) / 2 + y0)
    }
  }
}