package model.playable

import model.nonplayable.{AWeapon,Enemy}

trait Playable {
  /**
   * Abstract method to get the name of the playable entity
  */
  def getName: String

  /**
   * Abstract method to get the Health points of the playable entity
   */

  def getHp: Int

  /**
   * Abstract method to get the Defense points of the playable entity
   */
  def getDp: Int

  /**
   * Abstract method to get the Weight of the playable entity
   */
  def getWeight: Int

  /**
   * Abstract Method to get the mana points of the playable entity
   */
  def getMana: Int

  /**
   * Abstract Method to know if Playable have a weapon or not
   */
  def haveWeapon: Option[AWeapon]

  def putWeapon( a: AWeapon): Unit
  def attackEnemy(target: Enemy): Int
  def wasAttacked(pain:Int) : Playable
}
