package org.game.escape

import processing.core._
import math._
import scala.util.Random
import java.awt.Dimension
import org.game.escape.gui._
import org.game.escape.game._
import scala.compat._

object Main extends PApplet {

  val (xWIDTH,xHEIGHT,xSCALE) = (320,160,4)

  private var test:Main = _

  def main(args: Array[String]) = {
    test = new Main
    val frame = new javax.swing.JFrame("Main")
    frame.getContentPane().add(test)
    test.init

    val size = new Dimension(xWIDTH*xSCALE+2,xHEIGHT*xSCALE+29)

    frame.pack
    frame.setVisible(true)
    frame.setResizable(false)
    frame.setPreferredSize(size)
    frame.setSize(size)
  }
}

class Main extends PApplet {

  val (xWIDTH, xHEIGHT, xSCALE) = (Main.xWIDTH*Main.xSCALE, Main.xHEIGHT*Main.xSCALE, Main.xSCALE)
  val PANEL_HEIGHT = 3*8*xSCALE
  var (lastFrames,frames,lastTime) = (0,0,0L)

  val itemScreen = new Screen(xWIDTH, PANEL_HEIGHT, xSCALE ,this)
  val game = new Game

  override def setup() = {  
    size(xHEIGHT*xSCALE,xWIDTH*xSCALE)
    frameRate(60)
    background(0,0,0)
    textSize(16*xSCALE)
  }

  def randRect(bit: Bitmap, xOffs: Int, yOffs: Int): Array[Int] = {
    var di = 0
    var dpix = itemScreen.pixels
    while(di < 1000) {
      val x0 = (game.time % 10000 + di * width/20) - width/2
      val y0 = 0
      dpix = itemScreen.draw(bit,x0,y0)
      di+=1
    }
    dpix
  }

  def rend(){
    image(itemScreen.render(game,randRect),0,xHEIGHT - PANEL_HEIGHT)
  }

  override def draw() = {
    background(0,0,0)
    game.tick
    rend()

    if(Platform.currentTime - lastTime > 1000){
      lastFrames = frames
      frames = 0
      lastTime = Platform.currentTime
    }
    fill(255,255,255)
    text(lastFrames,xWIDTH - 20*xSCALE,15*xSCALE)
    frames +=1
  }
}