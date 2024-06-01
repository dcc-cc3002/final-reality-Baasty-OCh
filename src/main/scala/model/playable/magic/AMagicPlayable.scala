package model.playable.magic

import exceptions.spells.{InvalidnoEnoughMana, InvalidspellTarget}
import exceptions.weapons.InvalidkindOfWeapon
import model.general.GameUnit
import model.playable.APlayable
import model.spell.Spell

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

  /**
   * The mana of the character.
   * This variable is private and represents the magical energy available for casting spells.
   */
  private var Mana: Int = mana

  /**
   * The spell that the character can cast.
   * This variable is public and represents the current spell associated with the character.
   */
  var spell: Spell

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

  /**
   * Checks if the character has enough mana to cast the current spell.
   * If the character has sufficient mana to cast the spell, returns "It is Enough".
   * Otherwise, throws an InvalidnoEnoughMana exception with a message indicating the mana insufficiency.
   *
   * @return "It is Enough" if the mana points are sufficient to cast the spell
   * @throws InvalidnoEnoughMana if the mana points are insufficient to cast the spell
   */
  def hasEnoughMana: String = {
    if (this.Mana < spell.getCost) {
      throw new InvalidnoEnoughMana(s"The character ${this.getName} does not have enough mana to use the spell.")
    } else {
      "It is Enough"
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

  def throwSpell(target: GameUnit): String = {
    try{
      this.hasMagicWeapon
      this.hasEnoughMana
      target.canSuffer(spell)
      spell.Effect(target)
      "nice spell"
    } catch {
      case _: InvalidspellTarget => s"The spell can not act in that target"
    }
  }



  def canSelectHealing(): Boolean
  def canSelectPoison(): Boolean
  def canSelectParalysis(): Boolean
  def canSelectFire(): Boolean
  def canSelectThunder(): Boolean


}
