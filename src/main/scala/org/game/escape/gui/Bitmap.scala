package org.game.escape.gui

import processing.core._
import scala.util.Random

class Bitmap(val width: Int, val height: Int, applet:PApplet) {
	val rand = new Random()
	val img:PImage = applet.createImage(width,height,2)
	img.loadPixels()
	img.pixels = Array.fill(width*height)((rand.nextInt(0xFF)<<24) + (rand.nextInt(0xFF)<<16) + (rand.nextInt(0xFF)<<8) + (rand.nextInt(0xFF)))
	img.updatePixels

	def draw():PImage = {
		img
	}
}