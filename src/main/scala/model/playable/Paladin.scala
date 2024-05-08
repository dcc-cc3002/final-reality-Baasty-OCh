package model.playable
import model.nonplayable.AWeapon
/**
 * "A paladin is thought of as a very balanced character,
 * not excelling excessively in any attribute but also
 * not possessing notable deficiencies compared to other characters."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana is zero for no magic characters
 */
class Paladin(name:String, healthPoints:Int,
              defensePoints:Int, weight:Int,
              mana:Int) extends APlayable(name, healthPoints, defensePoints,weight,mana){

  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   * @return Playable
   */
  def this(name:String) = {
    this(name,100,75,50,0)
  }

  /**
   *
   * @param weapon
   */

  override def putWeapon(weapon: AWeapon): Unit = {
    arma = Some(weapon)
  }

  /**
   *
   * @param target
   */



  def wasAttacked(pain: Int): Playable = {
    if (this.healthPoints >= pain){
      val Paladin: Playable = new Paladin(this.name,this.healthPoints-pain,this.defensePoints,this.weight,this.mana)
      Paladin
    }
    else {
      val Paladin: Playable = new Paladin(this.name,0,this.defensePoints,this.weight,this.mana)
      Paladin
    }

  }

  override def getMana: Int = 0
}

 // Override equals method to compare two characters based on their attributes






