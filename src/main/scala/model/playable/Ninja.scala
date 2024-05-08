package model.playable

import model.nonplayable.AWeapon


/**
 *"A ninja is a key character in any game;
 * they may not excel in defensive arts but can be decisive due to their high attack speed."
 *
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana is zero for no magic characters
 */
class Ninja(name:String, healthPoints:Int,
            defensePoints:Int, weight:Int,
            mana:Int) extends APlayable(name,healthPoints, defensePoints,weight,mana){
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,80,70,30,0)
  }

  override def putWeapon(a: AWeapon): Unit = {
    arma = Some(a)
  }


  def wasAttacked(pain: Int): Playable = {
    if (this.healthPoints >= pain){
      val Ninja: Playable = new Ninja(this.name,this.healthPoints-pain,this.defensePoints,this.weight,this.mana)
      Ninja
    }
    else{
      val Ninja: Playable = new Ninja(this.name,0,this.defensePoints,this.weight,this.mana)
      Ninja
    }
  }
  override def getMana: Int = 0
}

