package model.playable
import model.nonplayable.AWeapon
import model.playable.APlayable
import model.nonplayable.{Staff,Wand}

/**
 * "A Black Mage will primarily be a magical attack character, though without excessively neglecting defense."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana reference to magic points of character
 */
class MagoNegro(name:String, healthPoints:Int,
                defensePoints:Int, weight:Int,
                mana:Int, armed : Option[AWeapon]) extends APlayable(name,healthPoints, defensePoints,weight,mana, armed) {
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   *  and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,90,60,50,50, None)
  }
}

/**
 * "A White Mage will predominantly have defensive qualities but with certain magical attributes."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana reference to magic points of character
 */
class MagoBlanco(name:String, healthPoints:Int,
                 defensePoints:Int, weight:Int,
                 mana:Int, armed: Option[AWeapon]) extends APlayable(name,healthPoints, defensePoints,weight,mana, armed) {
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   *  and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,100,80,60,40, None)
  }
}
