package model.nonplayable

/**
 * An enemy is a type of non-playable character that represents the adversary
 * or adversaries to be defeated by the group of players.
 *
 * @param name The name of the enemy.
 * @param life The life points of the enemy.
 * @param defence The defence points of the enemy.
 * @param weight The weight of the enemy.
 * @param attackPoints The attack points of the enemy.
 */
class Enemy(name: String, life: Int, defence: Int,
                  weight: Int, attackPoints: Int, status: String) extends AEnemy(name, life, defence, weight, attackPoints, status) {
  private val InitialHp : Int = 250
  override def maxHp(): Int = InitialHp

  /**
   * Auxiliary constructor that initializes an enemy with default statistics based on the enemy class.
   * @param name The name chosen for the enemy.
   * @return An instance of the Enemy class with preset default statistics. */
  def this(name: String) = {
    this(name, 250, 50, 60, 80, "Sano")
  }

  /**
   * Checks if this Enemy is equal to another Enemy instance based on their attributes.
   * @param other The object to compare against.
   * @return `true` if the objects are of the same class and have the same name, weight, life points, and defence points, `false` otherwise. */
  override def equals(other: Any): Boolean = {
    if (other.isInstanceOf[Enemy]) {
      val otherCast = other.asInstanceOf[Enemy]
      getClass == otherCast.getClass &&
        getName == otherCast.getName &&
        getWeight == otherCast.getWeight &&
        getHp == otherCast.getHp &&
        getDp == otherCast.getDp
    } else false
  }
}
