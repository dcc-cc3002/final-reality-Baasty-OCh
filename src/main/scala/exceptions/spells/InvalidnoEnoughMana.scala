package exceptions.spells

class InvalidnoEnoughMana(messages: String) extends Exception{
  override def getMessage: String = messages

}
