package org.game.escape.gui

import processing.core._
import scala.util.Random
import scala.compat._
import org.game.escape.game._

class Screen(override val width: Int, override val height: Int, scale: Int, pixels: Array[Int], maps: Array[Bitmap], applet:PApplet) extends Bitmap(width,height,pixels) {

	def this(width: Int, height: Int, scale: Int, bitmaps: Array[Bitmap], applet:PApplet) = this(width,height,scale,Array.fill(width*height)(0x00000000), bitmaps ,applet)
	def this(width: Int, height: Int, scale: Int, applet:PApplet) = this(width,height,scale,Array.fill(width*height)(0x00000000), Array(new Bitmap(8*3*scale,height)) ,applet)

	val img:PImage = applet.createImage(width,height,2)
	var bitmaps = maps

	def render(game: Game):PImage = {
		render(game, draw)
	}

	def render(game: Game, func: (Bitmap, Int, Int) => Array[Int]):PImage = {
		img.loadPixels
		clearPix
		for(bitmap <- bitmaps) img.pixels = func(bitmap,0,0)
		img.updatePixels
		img
	}
}