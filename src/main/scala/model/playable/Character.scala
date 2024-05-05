package model.playable
import model.nonplayable.AWeapon
import model.playable.Playable
import model.playable.APlayable
import model.nonplayable.NonPlayable
import model.nonplayable.{Axe,Sword,Staff,Bow,Wand}


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
              mana:Int, armed: Option[AWeapon]) extends APlayable(name, healthPoints, defensePoints,weight,mana, armed){
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,100,75,50,0, Some(new Sword()))
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
               mana:Int, armed :Option[AWeapon] ) extends APlayable(name,healthPoints, defensePoints,weight,mana,armed){
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,120,100,70,0, Some(new Axe()))
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
            mana:Int, armed : Option[AWeapon] ) extends APlayable(name,healthPoints, defensePoints,weight,mana,armed){
  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   * and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,80,70,30,0, Some( new Bow()))
  }
  override def getMana: Int = 0
}

 // Override equals method to compare two characters based on their attributes






