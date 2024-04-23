package model.playable
import model.playable.Playable
import model.playable.APlayable
// Character class extends the Playable trait
class Paladin(name:String) extends APlayable(name,100,50,50,"Paladin",false) {

}
class Guerrero(name:String) extends APlayable(name,120,80,50,"Guerrero",false) {

}
class Ninja(name:String) extends APlayable(name,50,80,20,"Ninja",false) {

}

  // Override equals method to compare two characters based on their attributes





