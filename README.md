# Final Reality
## Introduction

Final Reality is a simplified version of the popular game Final Fantasy. Its main objective is to serve as an educational tool designed to teach fundamental programming concepts. It is a video game whose code tests concepts related to object-oriented programming (OOP), such as Testing, Classes, Traits, Inheritance, Abstract Classes, Overriding, Liskov, Exceptions, Double Dispatch, Design Patterns, and Pattern Matching.

## Design Decisions-Model

### Traits

#### The Game Unit Trait:
This trait aggregates the behavior of entities in this game. Some of the most relevant methods are: getName, getHp, getWeight, setHp, etc. Since many of these methods are common for allies and enemies, it made sense to create this Scala interface. Additionally, as detailed later, the data structures with which the controller interacts with the characters are "mixed," meaning they (should) receive both classes of entities.

#### The Playable Trait:
This trait maintains cohesion among the different types of characters (Paladin, Ninja, Warrior, White Mage, Black Mage) but separates some behaviors and/or methods from the enemies. This step is crucial because we will later need to use this trait as a type to discern the type of entity we are using in the game (the controller actually does this on its own :)).

##### The MagicPlayable Trait:
Just to use "MagicPlayable" as a type if we needed it.

#### The NonPlayable Trait:
This trait clearly complements the previous one. Together, they seek to cover all the functionalities that an entity can have in the game, considered a GameUnit. Some of the most relevant methods are: SetStatus (reflects the effect of spells), getAttack (delivers the enemy's attack points), getWeight (key to calculating the enemy's turn), among others.

#### The Weapon Trait:
This trait is used to represent a weapon in the game environment. Among the most notable methods are: getWeight, getAttack, getOwner, setOwner, etc.

#### The Spell Trait:
This represents spells within the game. Establishing a proper interface is key to better interacting with the mages and the enemies who will suffer the effects.

### Abstract Classes:
Abstract classes are used to represent characters and enemies, allowing code reuse and flexibility to define specific behaviors in subclasses. There are two in the case of characters and one in the case of enemies.

#### APlayable
This class implements all the functionality that a player in the game can/must have (based on the demands of its trait). Here are the specifications of crucial methods such as: attack (specifies the series of steps to successfully attack an enemy), wasAttacked (indicates how a player responds to a certain enemy attack), and some auxiliary methods that, through the technique of double dispatch, allow us to know the class of the character we are using (Style, IAmCommon, IAmMagic, etc.).

#### AEnemy
Similar to the traits, this abstract class is nothing more than the complement of the previous one, which implements the necessary specifications for the proper functioning of the enemy and its interaction with other entities/classes/objects in the game.

#### AMagicPlayable
The second abstract class for characters refers to the magical characters. It basically takes the methods of APlayable (actually from the Trait) and 'adapts' them to the functionalities that a mage must have, such as having Mana, having Spells, attacking, attacking with spells, healing with spells, etc.

#### AWeapon
Here, the aforementioned methods are implemented, providing functionality to the objects that extend from it.

#### ACommonWeapon and AMagicWeapon:
Just as there are 2 types of characters, there are 2 types of weapons. Each has its own abstract classes, which detail certain extra specifications for the proper functioning of the game.

#### ASpell:
Various defaults are established, such as the probability of causing an effect, knowing whether it can act on an enemy/ally, and obtaining the owner of that spell.

### Classes:
#### Paladin:
A class to represent a paladin in the game. This will be a "normal" and balanced character type, versatile without too much health, attack, or shield.

#### Ninja:
Aims to be a very fast character. Its weight depends almost entirely on the weapon it carries, making it very lethal in certain situations.

#### Warrior:
The tank of the game, with a lot of health, very heavy, and a bit grumpy, haha.

#### White Magician:
The healer of the group, a key support character in long duels. Not very interested in attacking, although they can wield quite powerful spells like poison. Their participation in the battle is usually more focused on helping their teammates.

#### Black Magician:
An absolute executioner, mercilessly seeking to torment their enemies. Very strong, fast, and full of Mana to cast powerful spells.

#### Enemy:
The class that creates enemy objects. These are quite balanced and are notable for having "low" attack points relative to their weight. However, this deficit is compensated by their ridiculously high amount of Health and Shield, making them formidable entities in long games.

#### Bow:
A light weapon selectable by White Mages, Ninjas, and Warriors.

#### Sword:
A powerful weapon selectable by Black Mages, Paladins, and Warriors.

#### Axe:
A mid-level weapon selectable by Paladins and Warriors.

#### Wand:
A light magical weapon selectable by White and Black Mages.

#### Staff:
A heavy magical weapon selectable by White and Black Mages.

#### Healing:
A Light-type spell, selectable only by the White Mage, heals allies up to 30% of their maximum health.

#### Paralysis:
A Light-type spell, selectable only by the White Mage, paralyzes enemies for one turn.

#### Poison:
A Light-type spell, selectable only by the White Mage, poisons enemies, causing them to suffer for 4 turns.

#### Fire:
A Dark-type spell, selectable only by the Black Mage, reduces health based on the caster's AP and burns enemies (with a 20% probability), causing them to suffer for 4 turns.

#### Thunder:
A Dark-type spell, selectable only by the Black Mage, reduces health based on the caster's AP and paralyzes enemies (with a 30% probability), causing them to suffer for 4 turns.

## Design Decisions-General:
### Party:
It has a trait to be used as a type and a concrete class that implements the necessary features. It is the data structure that contains the allies in the game.

### TurnSchedule:
It has a trait to be used as a type and a concrete class that implements the necessary features. It is the data structure responsible for assigning turns to the participants in a battle, one of the fundamental components of the controller.

### GameModel:
Here lies the key to the game itself. Allies, enemies, weapons, and their characteristics are established here. The game's difficulty is defined from here.

### BattleGame:
Here, some controller methods are connected through the `run` method to "start" the game.


## Design Decisions-View:
While the task is aimed for the subject assistants to test and approve it, I wanted to make the view as explanatory as possible. Therefore, I implemented many "unnecessary" methods that only add more depth to the game itself and to the user experience. Some of these include adding colors to characters according to their state, notifying when attempting to choose an improper weapon or spell without sufficient Mana, etc.

Here's the translation:

**Design Decisions-Exceptions:**
To prevent the game from crashing at runtime in an "unexplainable" manner, we've adorned such crashes with exceptions. These prevent the code from breaking and cover certain quite plausible edge cases. Some of the most notable ones include: InvalidEnoughMana, InvalidAdditionParty, InvalidSelect[NameOfSpell], InvalidPut[NameOfWeapon]Exception.
# Estados:
![Diagram of states in game](Final_Diagram.png)



## TurnState:
God in person, the initial and final state of the game, everything goes through here, He decides it all. It receives a TurnSchedule with the combat participants (allies and enemies). Based on their weight, it calculates who plays first and passes the baton to the next state (as appropriate).
In the specific game model implemented in GameModel, the character Zidane has the lowest weight. Therefore (since he isn't armed from the beginning), he is the one who starts playing. I will continue detailing the gameplay flow from his perspective...


## InitialPlayerState:
The starting state of a player's turn, it notifies that the turn has begun and prepares the environment for it. The update directs us towards UnitState.

## UnitState:
In this state, we discern whether the player for this turn is magical or common. Since in this example, the player is magical, we will follow that gameplay flow.

## ActionMagicState:
Here, a wider range of options opens up for execution. The state presents different options such as: leaving the game, attacking, attacking with magic, changing the weapon, or changing the spell. Depending on our choice, we will proceed accordingly. For this example, we will attack with magic, moving to SpellState.

## SpellState:
Here, as expected, we choose the spell we want to equip. All spells in the game are displayed, but we will only proceed to choose a weapon if we select a dark spell (for our Black Mage). Both fire and thunder will lead us to WeaponMagicState.

## WeaponMagicState:
Derived from the SpellState, we are "obligated" to select a magical weapon (provided another character is not using it). The options are Wand and Staff, and either choice will send us to TargetMagicState.

## TargetMagicState:
Once we have selected our spell and equipped our magical weapon, we only need to choose the final target. The party of enemies from the GameModel is displayed on the screen, showing the options. As long as the enemy is alive, choosing it will lead us to FinalMagicState.

## FinalMagicState:
Here, the corresponding attack action is executed. In this case, the spell is cast on our target, and we close the cycle, returning to TurnState.

## InitialEnemyState:
Now it's the enemy's turn. This state notifies that it begins and will check the enemy's state to act. Suppose our character cast fire on the enemy, and it got burned. If that is the case, the enemy's state will be "Burned with [Nameofweapon]", leading to BurnedState.

## BurnedState:
Here, the "secondary" effects of being burned are applied. The enemy loses life relative to the weapon with which it was burned and continues playing (if it dies after these effects, it directly returns to TurnState).

## TargetEnemyState:
If the enemy survived its current state, it will choose whom to attack. The selection is made randomly (respecting the rule of not attacking dead targets) and will move to FinalEnemyState.

## FinalEnemyState:
Here, the enemy's single attack action is executed, returning to TurnState.

## ActionState:
Suppose the next player to play is not magical but a paladin. This player will have only three options: leave the game, attack, or change the weapon. If the player wants to change their weapon, they will go to WeaponState.

## WeaponState:
All weapons are displayed here, similar to before, along with a message indicating that not all are selectable, depending on availability. We proceed accordingly (if an unavailable option is chosen, we return to WeaponState until a valid option is selected). Suppose the sword is chosen; it has 70 AP and 70 WP, and the weight is added to the player (which will count towards calculating their next turn).

## TargetState:
Same as TargetMagicState.

## FinalState:
Same as FinalMagicState.

## ParalyzedState:
A particular state (since poison is very similar to burned) is the paralyzed state. If the InitialEnemyState detects that the enemy is in this state, it moves to "ParalyzedState", which directly connects to TurnState and ends the turn (the state is cleared depending on the turn).

## Coverage:
Si bien el All es 86%, el profesor dijo que no habia que contar la view, el porcetaje de los 3 grandes paquetes es 90%

Final Reality is an educational project that uses programming concepts to create a simplified game. The organization of code into packages and the use of design patterns such as inheritance and traits make the code modular, readable, and easy to maintain.
This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).