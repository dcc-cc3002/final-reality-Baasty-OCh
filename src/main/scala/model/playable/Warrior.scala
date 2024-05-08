package model.playable

import model.nonplayable.AWeapon

/**
 * "The warrior is a character designed
 * to be the main powerhouse of a team,
 * very resilient but somewhat slow;
 * this is often referred to as the game's 'tank'."
 *
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana is zero for no magic characters
 */
class Warrior(name:String, healthPoints:Int,
               defensePoints:Int, weight:Int,
               mana:Int) extends APlayable(name,healthPoints, defensePoints,weight,mana){
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,120,100,70,0)
  }

  override def putWeapon(a: AWeapon): Unit = {
    arma = Some(a)
  }


  def wasAttacked(pain: Int): Playable = {
    if (this.healthPoints >= pain){
      val Warrior: Playable = new Warrior(this.name,this.healthPoints-pain,this.defensePoints,this.weight,this.mana)
      Warrior
    }
    else {
      val Warrior: Playable = new Warrior(this.name,0,this.defensePoints,this.weight,this.mana)
      Warrior
    }

  }
  override def getMana: Int = 0
}
