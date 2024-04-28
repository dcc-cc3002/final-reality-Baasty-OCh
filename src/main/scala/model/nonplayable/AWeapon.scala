package model.nonplayable
import model.nonplayable.ANonPlayable
import model.playable.Playable


abstract class AWeapon(name: String, weight: Int,
             attack: Int, owner: Playable) extends ANonPlayable (name,weight,attack) {

}




