package model.nonplayable
import model.nonplayable.NonPlayable

// Enemy class represents a non-playable entity that is an enemy
class Enemy(name: String, weight: Int,
            attack: Int, life: Int,
            defence: Int) extends ANonPlayable(name,weight,attack) {

}
