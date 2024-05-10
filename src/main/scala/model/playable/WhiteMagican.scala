package model.playable

import model.nonplayable.weapons.AWeapon
import model.nonplayable.{Enemy, Staff, Wand}
import model.playable.APlayable

/**
 * "A White Mage will predominantly have defensive qualities but with certain magical attributes."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana reference to magic points of character
 */
class WhiteMagican(name:String, healthPoints:Int,
                 defensePoints:Int, weight:Int,
                 mana:Int) extends APlayable(name,healthPoints, defensePoints,weight,mana) {
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   *  and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,100,80,60,40)
  }
  override def putWeapon(a: AWeapon): Unit = {
    arma = Some(a)
  }

  def wasAttacked(pain: Int): Playable = {
    if (this.healthPoints >= pain) {
      val WhiteMagican: Playable = new WhiteMagican(this.name, this.healthPoints - pain, this.defensePoints, this.weight, this.mana)
      WhiteMagican
    }
    else {
      val WhiteMagican: Playable = new WhiteMagican(this.name, 0, this.defensePoints, this.weight, this.mana)
      WhiteMagican
    }
  }
}
