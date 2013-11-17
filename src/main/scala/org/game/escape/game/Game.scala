package org.game.escape.game

class Game {
	var time = 0
	def tick() {
		time+=1
		if(time>10000000) time = 0
	}

}