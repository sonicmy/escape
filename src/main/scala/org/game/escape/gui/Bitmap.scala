package org.game.escape.gui

import processing.core._
import scala.util.Random

class Bitmap(val width: Int, val height: Int, var pixels: Array[Int]) {
	
	private def this(width: Int, height: Int, rand: Random) = this(width,height,Array.fill(width*height){
		val rn = rand.nextInt * rand.nextInt(2)
		if(rn > 0) rn else 0
		})

	def this(width: Int, height: Int) = this(width,height,new Random)

	def draw(bitmap:Bitmap, xOffs: Int, yOffs: Int): Array[Int] = {
		for { y <- 0 until bitmap.height
		      val yPos = y + yOffs
			  if(yPos >= -1 && yPos < height) 
			  x <- 0 until bitmap.width
		      val xPos = x + xOffs
			  if(xPos >= -1 && xPos < width)} 
			  	pixels(xPos+yPos*width) = bitmap.pixels(x+y*bitmap.width)
		pixels
	}

	def clearPix = pixels = Array.fill(width*height)(0x00000000)
}