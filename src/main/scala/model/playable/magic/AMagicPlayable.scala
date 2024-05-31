package model.playable.magic

import exceptions.spells.InvalidnoEnoughMana
import exceptions.weapons.InvalidkindOfWeapon
import model.general.GameUnit
import model.playable.APlayable
import model.weapons.magic.AMagicWeapon
import model.spell.Spell
import model.weapons.Weapon

/**
 * Abstract class to made a group of magic characters
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana The mana of the character.
 */
abstract class AMagicPlayable(name:String, healthPoints:Int,
                              defensePoints:Int, weight:Int,
                              mana:Int) extends APlayable(name,healthPoints, defensePoints,weight) {
  private var Mana: Int = mana
  var Spell: Option[Spell] = None


  /**
   * Implementation of Method to get the mana points of the playable entity
   * @return The mana of playable entity
   */
  def getMana: Int = Mana

  /**
   * Implementation of Method to set the mana points of the playable entity
   * @param newMana represent the new mana points of the playable entity
   */
  def setMana(newMana:Int): Unit = {
    this.Mana = newMana
  }
  def hasSpell: Option[Spell] = Spell

  def checkMana: Boolean = {
  if (this.Mana < Spell.map(_.getCost).getOrElse(15)){
    throw new InvalidnoEnoughMana
  } else
    true
  }

  def hasEnoughMana: String = {
    try{
      this.checkMana
      "It is Enough"
    } catch {
      case _: InvalidnoEnoughMana => s"The character ${this.getName} has not the enough mana to use the Spell"
    }
  }

  def hasMagicWeapon: String = {
    try{
      this.arma.map(_.iAmMagic).getOrElse(false)
      "good"
    } catch {
      case _: InvalidkindOfWeapon => s" The weapon is not magic"
    }
   }

  def selectSpell(spell: Spell): String

  def throwSpell(objective: GameUnit): Unit = {
    //try{
      //this.hasEnoughMana
      //this.setMana(this.mana - Spell.map(_.getCost).getOrElse(0))
      //Spell.map(_.detEffect).getOrElse(0)}

    }



  def canSelectHealing(): Boolean
  def canSelectPoison(): Boolean
  def canSelectParalysis(): Boolean
  def canSelectFire(): Boolean
  def canSelectThunder(): Boolean


}
