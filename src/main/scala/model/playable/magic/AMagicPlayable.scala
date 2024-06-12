package model.playable.magic

import controller.observers.ObserverAttack
import exceptions.spells.{InvalidNoEnoughMana, InvalidSpellTarget}
import exceptions.weapons.InvalidKindOfWeapon
import model.general.GameUnit
import model.playable.APlayable
import model.spell.Spell

import scala.collection.mutable.ArrayBuffer

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
                              mana:Int) extends APlayable(name,healthPoints, defensePoints,weight) with MagicPlayable {

  /**
   * The mana of the character.
   * This variable is private and represents the magical energy available for casting spells.
   */
  private var Mana: Int = mana

  private var _spells = ArrayBuffer.empty[Spell]


  override def spells(): ArrayBuffer[Spell] = _spells.clone()
  def addSpell(spell: Spell): Unit = _spells += spell

  /**
   * The spell that the character can cast.
   * This variable is public and represents the current spell associated with the character.
   */
  var spell: Spell

  /**
   * Implementation of Method to get the mana points of the playable entity
   *
   * @return The mana of playable entity
   */
  override def getMana: Int = Mana

  override def HowIPlay(): String = "magicPlayable"

  override def IAmMagic(): Int = 2

  override def IsMagic(gameUnit: GameUnit): Int = {
    gameUnit.IAmMagic()
  }

  /**
   * Implementation of Method to set the mana points of the playable entity
   *
   * @param newMana represent the new mana points of the playable entity
   */
  def setMana(newMana: Int): Unit = {
    this.Mana = newMana
  }

  /**
   * Checks if the character has enough mana to cast the current spell.
   * If the character has sufficient mana to cast the spell, returns "It is Enough".
   * Otherwise, throws an InvalidnoEnoughMana exception with a message indicating the mana insufficiency.
   *
   * @return "It is Enough" if the mana points are sufficient to cast the spell
   * @throws InvalidNoEnoughMana if the mana points are insufficient to cast the spell
   */
  def hasEnoughMana: String = {
    if (this.Mana < spell.getCost) {
      throw new InvalidNoEnoughMana(s"The character ${this.getName} does not have enough mana to use the spell.")
    } else {
      "It is Enough"
    }
  }

  /**
   * Checks if the character has a magic weapon equipped.
   * If the character has a magic weapon equipped, returns "good".
   * Otherwise, throws an InvalidkindOfWeapon exception with a message indicating that the weapon is not magic.
   *
   * @return "good" if the character has a magic weapon equipped
   * @throws InvalidKindOfWeapon if the character does not have a magic weapon equipped
   */
  def hasMagicWeapon: String = {
    try {
      this.arma.exists(_.iAmMagic)
      "Yes"
    } catch {
      case _: InvalidKindOfWeapon => s" The weapon is not magic"
    }
  }

  /**
   * Allows the character to choose a spell for casting.
   * @param spell The spell to be chosen by the character.
   * @return A message indicating the success of the spell selection.
   */
  def selectSpell(spell: Spell): String

  /**
   * Throws a spell at a target game unit.
   * This method performs several checks before throwing the spell:
   *   - It verifies if the character has a magic weapon equipped.
   *   - It checks if the character has enough mana to cast the spell.
   *   - It verifies if the target can suffer the effects of the spell.
   *   - Finally, it applies the effects of the spell on the target.
   *
   * @param target The game unit at which the spell is aimed.
   * @return A message indicating the success of casting the spell.
   * @throws InvalidSpellTarget if the spell cannot act on the specified target.
   */
  override def throwSpell(target: GameUnit): String = {
    try {
      this.hasMagicWeapon
      this.hasEnoughMana
      target.canSuffer(spell)
      this.setMana(this.getMana-spell.getCost)
      for (o <- attackObs) {
        o.notifySpellAttack(this, target, spell, 5)
      }
      spell.Effect(target)
      "nice spell"
    } catch {
      case _: InvalidSpellTarget => s"The spell can not act in that target"
    }
  }

  /**
   * Abstract method to checks if the character can select a healing spell.
   * @return true if the character can select a healing spell, false otherwise.
   */
  def canSelectHealing(): Boolean

  /**
   * Abstract method to checks if the character can select a poison spell.
   * @return true if the character can select a poison spell, false otherwise.
   */
  def canSelectPoison(): Boolean

  /**
   * Abstract method to checks if the character can select a paralysis spell.
   * @return true if the character can select a paralysis spell, false otherwise.
   */
  def canSelectParalysis(): Boolean

  /**
   * Abstract method to checks if the character can select a fire spell.
   * @return true if the character can select a fire spell, false otherwise.
   */
  def canSelectFire(): Boolean

  /**
   * Abstract method to checks if the character can select a thunder spell.
   * @return true if the character can select a thunder spell, false otherwise.
   */
  def canSelectThunder(): Boolean
}
