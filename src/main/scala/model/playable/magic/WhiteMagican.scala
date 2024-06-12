package model.playable.magic

import exceptions.spells.{InvalidSelectFireSpell, InvalidSelectHealingSpell, InvalidSelectParalysisSpell, InvalidSelectPoisonSpell, InvalidSelectThunderSpell}
import exceptions.weapons.{InvalidPutAxeException, InvalidPutSwordException, InvalidPutWeaponException}
import model.spell.Spell
import model.spell.light.{Healing, Paralysis, Poison}
import model.weapons.Weapon
import model.weapons.common.{Axe, Bow, Sword}
import model.weapons.magic.{Staff, Wand}

/**
 * "A White Mage will predominantly have defensive qualities but with certain magical attributes."
 *
 * @param name The name of the character.
 * @param healthPoints The health points of the character.
 * @param defensePoints The defense points of the character.
 * @param weight The weight of the character.
 * @param mana reference to magic points of character
 */
class WhiteMagican(name:String, healthPoints:Int,
                 defensePoints:Int, weight:Int,
                 mana:Int) extends AMagicPlayable(name,healthPoints, defensePoints,weight,mana) {
  addSpell(new Healing)
  addSpell(new Paralysis)
  addSpell(new Poison)
  var spell : Spell = spells.head

  /**
   * "The auxiliary builder receives the name that the user chooses for their character
   *  and sets the other statistics according to the chosen class."
   * @param name
   */
  def this(name:String) = {
    this(name,100,80,60,40)
  }

  /**
   * Implementation of Method to put a Weapon on a Playable Entity (Warrior)
   * @param weapon class of AWeapon (any sub-class of abstract class; Sword, Axe, Bow, Wand and Staff)
   * @return positive message if the Warrior Can equip the weapon,
   *         negative one in other cases, with his particular exception.
   */
  def putWeapon(weapon: Weapon): String = {
    try {
      weapon.canBeEquippedBy(this)
      this.arma = Some(weapon)
      weapon.setOwner(this)
      "The weapon was wear"
    } catch {
      case _:InvalidPutSwordException => s"The character: ${this.getName} can't wear a Sword"
      case _:InvalidPutAxeException => s"The character: ${this.getName} can't wear an Axe"
      case _:InvalidPutWeaponException => s"The weapon: ${weapon.getName} already has an owner"
    }
  }

  /**
   * Allows the playable entity to select a spell.
   *
   * @param spell The spell to be selected.
   * @return A message indicating whether the spell was successfully selected or an exception message if the spell cannot be selected.
   */
  override def selectSpell(spell: Spell): String = {
    try {
      spell.canBeSelectedBy(this)
      this.spell = spell
      "The spell was selected"
    } catch {
      case _: InvalidSelectFireSpell => s"The character ${this.getName} can't select a Fire Spell"
      case _: InvalidSelectThunderSpell => s"The character ${this.getName} can't select a Thunder Spell"
    }
  }

  /**
   * Indicates whether the playable entity can select a Healing spell.
   * @return Always returns true.
   */
  override def canSelectHealing(): Boolean = true

  /**
   * Indicates whether the playable entity can select a Poison spell.
   * @return Always returns true.
   */
  override def canSelectPoison(): Boolean = true

  /**
   * Indicates whether the playable entity can select a Paralysis spell.
   * @return Always returns true.
   */
  override def canSelectParalysis(): Boolean = true

  /**
   * Indicates whether the playable entity can select a Fire spell.
   * @return Always throws an InvalidselectFireSpell exception.
   */
  override def canSelectFire(): Boolean = throw new InvalidSelectFireSpell

  /**
   * Indicates whether the playable entity can select a Thunder spell.
   * @return Always throws an InvalidselectThunderSpell exception.
   */
  override def canSelectThunder(): Boolean = throw new InvalidSelectThunderSpell

  /**
   * Implementation of method to check if a Playable entity can equip 'Axe'
   * @param w represent the Axe
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipAxe(w: Axe): Boolean = throw new InvalidPutAxeException

  /**
   * Implementation of method to check if a Playable entity can equip 'Sword'
   * @param w represent the Sword
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipSword(w: Sword): Boolean = throw new InvalidPutSwordException

  /**
   * Implementation of method to check if a Playable entity can equip 'Bow'
   * @param w represent the Bow
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipBow(w: Bow): Boolean = true

  /**
   * Implementation of method to check if a Playable entity can equip 'Staff'
   * @param w represent the Staff
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipStaff(w: Staff): Boolean = true

  /**
   * Implementation of method to check if a Playable entity can equip 'Wand'
   * @param w represent the Wand
   * @return true if the playable can equip the weapon, false in other case
   */
  override def canEquipWand(w: Wand): Boolean = true


  /**
   * Checks if this WhiteMagican is equal to another WhiteMagican.
   * @param other The object to compare against
   * @return `true` if the objects are of the same class, `false` otherwise
   */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[WhiteMagican]) {
      val otherCast = other.asInstanceOf[WhiteMagican]
      (getClass() == otherCast.getClass() &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp &&
        getMana == otherCast.getMana)

    } else false
  }
}
