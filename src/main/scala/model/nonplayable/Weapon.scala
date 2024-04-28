package model.nonplayable
import model.nonplayable.ANonPlayable
import model.playable.Playable

// Weapon class represents a non-playable entity that is a weapon
class Weapon(name: String, weight: Int,
             attack: Int, owner: Playable) extends ANonPlayable (name,weight,attack) {

}
