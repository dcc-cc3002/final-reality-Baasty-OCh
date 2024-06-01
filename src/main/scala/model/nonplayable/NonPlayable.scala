package model.nonplayable

import model.general.GameUnit
import model.playable.Playable
import model.spell.Spell

// Trait to represent non-playable entities
trait NonPlayable extends GameUnit{
  /**
   * Abstract method to get the name of the non-playable entity
   * @return The name of the non-playable entity as a String
   */
  def getName: String

  /**
   * Abstract method to get the weight of the non-playable entity
   * @return The weight of the non-playable entity as an integer
   */
  def getWeight: Int


  /**
   * Abstract method to get the attack points of the non-playable entity
   * @return The attack points of the non-playable entity as an integer
   */
  def getAttack: Int

  /**
   * Abstract method to checks if the non-playable entity can suffer the effects of a spell.
   * @param spell The spell being cast.
   * @return true if the spell can affect the non-playable entity, false otherwise.
   */
  def canSuffer(spell: Spell): Boolean
}

