package model.playable.magic

import exceptions.spells.{InvalidNoEnoughMana, InvalidSpellTarget}
import exceptions.weapons.InvalidKindOfWeapon
import model.general.GameUnit
import model.playable.APlayable
import model.spell.Spell
import model.spell.dark.{Fire, Thunder}
import model.spell.light.{Healing, Paralysis, Poison}

import scala.collection.mutable.ArrayBuffer

/**
 * Abstract class representing a magic playable entity in the game.
 *
 * @param name           The name of the character.
 * @param healthPoints   The health points of the character.
 * @param defensePoints  The defense points of the character.
 * @param weight         The weight of the character.
 * @param mana           The mana points of the character.
 */
abstract class AMagicPlayable(name: String, healthPoints: Int,
                              defensePoints: Int, weight: Int,
                              mana: Int) extends APlayable(name, healthPoints, defensePoints, weight) with MagicPlayable {


  /**
   * Private variable representing the magical energy available for casting spells. */
  private var Mana: Int = mana

  private val _spells = ArrayBuffer.empty[Spell]

  /**
   * Retrieves a clone of the spells available to the magic playable entity.
   * @return A clone of the ArrayBuffer containing the spells. */
  override def spells(): ArrayBuffer[Spell] = _spells.clone()

  /**
   * Method to add a spell to the magic playable entity's repertoire.
   * @param spell The spell to add. */
  def addSpell(spell: Spell): Unit = _spells += spell

  // Adding default spells
  addSpell(new Healing)
  addSpell(new Paralysis)
  addSpell(new Poison)
  addSpell(new Fire)
  addSpell(new Thunder)




  /**
   * Retrieves the current mana points of the magic playable entity.
   * @return The current mana points. */
  override def getMana: Int = Mana

  /**
   * Overrides the playing style method to indicate that this entity is a magic playable.
   * @return The string "magicPlayable". */
  override def HowIPlay(): String = "magicPlayable"

  /**
   * Returns the identifier indicating that this entity is magical.
   * @return The integer 2. */
  override def IAmMagic(): Int = 1

  /**
   * Retrieves the magical identifier of another GameUnit entity.
   * @param gameUnit The entity being queri
   * @return The result of calling `IAmMagic()` on the queried entity. */
  override def IsMagic(gameUnit: GameUnit): Int = {
    gameUnit.IAmMagic()
  }

  /**
   * Sets the current mana points of the magic playable entity.
   * @param newMana The new mana points. */
  def setMana(newMana: Int): Unit = {
    this.Mana = newMana
  }

  /**
   * Checks if the magic playable entity has enough mana to cast the current spell.
   * If enough mana is available, returns "It is Enough".
   * Otherwise, throws an InvalidNoEnoughMana exception.
   * @return "It is Enough" if sufficient mana is availab
   * @throws InvalidNoEnoughMana if insufficient mana is available. */
  def hasEnoughMana: String = {
    if (this.Mana < this.spell.map(_.getCost).getOrElse(0)){
      throw new InvalidNoEnoughMana(s"The character ${this.getName} does not have enough mana to use the spell.")
    } else {
      "It is Enough"
    }
  }

  /**
   * Checks if the magic playable entity has a magic weapon equipped.
   * If a magic weapon is equipped, returns "Yes".
   * Otherwise, throws an InvalidKindOfWeapon exception.
   * @return "Yes" if a magic weapon is equipp
   * @throws InvalidKindOfWeapon if no magic weapon is equipped. */
  def hasMagicWeapon: String = {
    try {
      this.arma.exists(_.iAmMagic)
      "Yes"
    } catch {
      case _: InvalidKindOfWeapon => s"The weapon is not magic"
    }
  }

  /**
   * Allows the magic playable entity to select a spell for casting.
   * @param spell The spell to be select
   * @return A message indicating the success of selecting the spell. */
  def selectSpell(spell: Spell): String

  /**
   * Throws the current spell at a target GameUnit entity.
   * Performs checks to ensure:
   * - The entity has a magic weapon equipped.
   * - The entity has enough mana to cast the spell.
   * - The spell can affect the target entity.
   * If all conditions are met, applies the spell's effects on the target.
   * @param target The target GameUnit entity.
   * @return A message indicating the success of casting the spe
   * @throws InvalidSpellTarget if the spell cannot affect the target entity. */
  override def throwSpell(target: GameUnit): String = {
    try {
      this.hasMagicWeapon
      this.hasEnoughMana
      target.canSuffer(spell.get)
      this.setMana(this.getMana - this.spell.map(_.getCost).getOrElse(0))
      for (o <- attackObs) {
        o.notifySpellAttack(this, target, spell.get, 0)
      }
      spell.get.Effect(target)
      this.dropSpell()
      "Nice spell"
    } catch {
      case _: InvalidSpellTarget => s"The spell cannot act on that target"
    }
  }

  /**
   * Abstract method to check if the magic playable entity can select a healing spell.
   * @return true if the entity can select a healing spell, false otherwise. */
  def canSelectHealing(): Boolean

  /**
   * Abstract method to check if the magic playable entity can select a poison spell.
   * @return true if the entity can select a poison spell, false otherwise. */
  def canSelectPoison(): Boolean

  /**
   * Abstract method to check if the magic playable entity can select a paralysis spell.
   * @return true if the entity can select a paralysis spell, false otherwise. */
  def canSelectParalysis(): Boolean

  /**
   * Abstract method to check if the magic playable entity can select a fire spell.
   * @return true if the entity can select a fire spell, false otherwise. */
  def canSelectFire(): Boolean

  /**
   * Abstract method to check if the magic playable entity can select a thunder spell.
   * @return true if the entity can select a thunder spell, false otherwise. */
  def canSelectThunder(): Boolean
}
