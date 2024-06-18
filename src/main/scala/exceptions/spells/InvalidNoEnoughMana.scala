package exceptions.spells

/**
 * Custom exception class to represent insufficient mana for spell casting.
 * This exception is thrown when a character does not have enough mana to cast a spell.
 * @param message The message describing the insufficient mana condition.
 */
class InvalidNoEnoughMana(message: String) extends Exception(message) {

  /**
   * Retrieves the message describing the insufficient mana condition.
   * @return The message describing the insufficient mana condition.
   */
  override def getMessage: String = message
}
