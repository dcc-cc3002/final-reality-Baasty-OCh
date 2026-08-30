package model.playable
import model.playable.Playable
import model.playable.APlayable
// Character class extends the Playable trait
class Paladin(name:String) extends APlayable(name,100,50,50,"Paladin",false,0) {

}
class Guerrero(name:String) extends APlayable(name,120,80,40,"Guerrero",false,0) {

}
class Ninja(name:String) extends APlayable(name,50,80,20,"Ninja",false,0) {

}
class MagoNegro(name:String) extends APlayable(name,100,100,120,"MagoNegro",false,50) {

}

class MagoBlanco(name:String) extends APlayable(name,50,150,100,"MagoBlanco",false,80) {

} // Override equals method to compare two characters based on their attributes





