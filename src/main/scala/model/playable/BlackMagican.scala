package model.playable

import model.nonplayable.AWeapon

/**
 * "A Black Mage will primarily be a magical attack character, though without excessively neglecting defense."
 *
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana reference to magic points of character
 */
class BlackMagican(name:String, healthPoints:Int,
                defensePoints:Int, weight:Int,
                mana:Int) extends APlayable(name,healthPoints, defensePoints,weight,mana) {
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   *  and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,90,60,50,50)
  }
  override def putWeapon(a: AWeapon): Unit = {
    arma = Some(a)
  }


  def wasAttacked(pain: Int): Playable = {
    if (this.healthPoints >= pain){
      val BlackMagican: Playable = new BlackMagican(this.name,this.healthPoints-pain,this.defensePoints,this.weight,this.mana)
      BlackMagican
    }
    else{
      val BlackMagican: Playable = new BlackMagican(this.name,0,this.defensePoints,this.weight,this.mana)
      BlackMagican
    }
  }
}

