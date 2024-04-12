package model.nonplayable
import model.nonplayable.NonPlayable
class Enemy(name:String,weight:Int,
            attack:Int,life:Int,
            defence:Int) extends NonPlayable{

  def sayName():String= {
    name
  }

  def sayWeight(): Int ={
    weight
  }

  def sayAttack(): Int = {
    attack
  }

  def sayLife() : Int = {
    life
  }

  def sayDefence() : Int = {
    defence
  }
}
