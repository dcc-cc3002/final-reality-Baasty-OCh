package model.playable
import model.nonplayable.{AWeapon, Axe, Bow, Enemy, NonPlayable, Staff, Sword, Wand}
import model.playable.Playable
import model.playable.APlayable


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

  override def attackEnemy(target: Enemy): Int = {
    val damage = arma.map(_.getAttack - target.getDF).getOrElse(0)
    damage
  }

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
/**
 * "The warrior is a character designed
 * to be the main powerhouse of a team,
 * very resilient but somewhat slow;
 * this is often referred to as the game's 'tank'."
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana is zero for no magic characters
 */
class Guerrero(name:String, healthPoints:Int,
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
  override def attackEnemy(target: Enemy): Int = {
    val damage = arma.map(_.getAttack - target.getDF).getOrElse(0)
    damage
  }

  def wasAttacked(pain: Int): Playable = {
    if (this.healthPoints >= pain){
      val Guerrero: Playable = new Guerrero(this.name,this.healthPoints-pain,this.defensePoints,this.weight,this.mana)
      Guerrero
    }
    else {
      val Guerrero: Playable = new Guerrero(this.name,0,this.defensePoints,this.weight,this.mana)
      Guerrero
    }

  }
  override def getMana: Int = 0
}
/**
 *"A ninja is a key character in any game;
 * they may not excel in defensive arts but can be decisive due to their high attack speed."
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
  override def attackEnemy(target: Enemy): Int = {
    val damage = arma.map(_.getAttack - target.getDF).getOrElse(0)
    damage
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

 // Override equals method to compare two characters based on their attributes






