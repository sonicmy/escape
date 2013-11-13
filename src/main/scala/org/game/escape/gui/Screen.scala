package org.game.escape.gui

import processing.core._
import scala.util.Random
import scala.compat._

class Screen(override val width: Int, override val height: Int, pixels: Array[Int], applet:PApplet) extends Bitmap(width,height,pixels) {

	def this(width: Int, height: Int, applet:PApplet) = this(width,height,Array.fill(width*height)(0x00000000),applet)

	val bitmap = new Bitmap(64,64)
	val img:PImage = applet.createImage(width,height,2)

	def render():PImage = {
		img.loadPixels
		clearPix
		for (i <- 0 to 100) {
	      val x0 = (math.sin(((Platform.currentTime + i * 16) % 2000 / 2000.0 * Math.PI * 2)) * width /  3).toInt
    	  val y0 = (math.cos(((Platform.currentTime + i * 16) % 2000 / 2000.0 * Math.PI * 2)) * height / 3).toInt
      	  img.pixels = draw(bitmap,(width-bitmap.width) / 2 + x0, (height-bitmap.height) / 2 + y0)
    	}
		img.updatePixels
		img
	}
}