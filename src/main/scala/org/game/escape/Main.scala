package org.game.escape

import processing.core._
import math._
import scala.util.Random
import java.awt.Dimension
import org.game.escape.gui._
import scala.compat._

object Main extends PApplet {

  val (xWIDTH,xHEIGHT,xSCALE) = (640,320,1)

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
  var (lastFrames,frames,lastTime) = (0,0,0L)
  val screen = new Screen(xWIDTH, xHEIGHT-100,this)

  override def setup() = {  
    size(xHEIGHT*xSCALE,xWIDTH*xSCALE)
    frameRate(60)
    background(0,0,0)
    textSize(16*xSCALE)
  }

  override def draw() = {
    //scale(xSCALE)
    background(0,0,0)

    image(screen.render,0,0)

    if(Platform.currentTime - lastTime > 1000){
      lastFrames = frames
      frames = 0
      lastTime = Platform.currentTime
    }
    fill(255,255,255)
    text(lastFrames,xWIDTH - 40,15)
    frames +=1
  }
}