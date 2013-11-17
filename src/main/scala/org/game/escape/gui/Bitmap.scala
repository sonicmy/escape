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
		val xLen =  Math.min(bitmap.width, width - xOffs)
		val yLen =  Math.min(bitmap.height, height - yOffs)
		if(xLen>0) {
		  var y = 0
		  while(y < yLen) {
			 	if(xOffs+(y+yOffs)*width > 0)
			 	Array.copy(bitmap.pixels, y*bitmap.width, pixels, xOffs+(y+yOffs)*width, xLen)
			 	y+=1
			 }
		}
		pixels
	}

	def clearPix = pixels = Array.fill(width*height)(0x00000000)
}