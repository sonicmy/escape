package org.game.escape.gui

import processing.core._

class Screen(override val width: Int, override val height: Int, applet:PApplet) extends Bitmap(width,height,applet) {
	
	override def draw():PImage = {
		new PImage
	}
}