# Final Reality

## Introducción

Final Reality es una versión simplificada del popular juego Final Fantasy. Su objetivo principal es servir como herramienta educativa, diseñada para enseñar los conceptos fundamentales de programación.

## Decisiones de Diseño

### Personajes y Enemigos

#### Clases abstractas: 
Se utilizan clases abstractas para representar personajes y enemigos, permitiendo la reutilización de código y la flexibilidad para definir comportamientos específicos en subclases. 

El diagrama de clases muestra la jerarquía de clases para personajes y enemigos:
En el trait 'Playable' se definene metodos getters y setters uitles para las implementaciones futuras

[Playable] --> A[APlayable] |En la clase abstracta 'APlayable' se implementan los metodos del trait, ademas de definir nuevos metodos especificos para el desarrollo de los metodos de cada personaje y sus acciones en el juego, como atacar, ser atacados, etc

A[APlayable] -->B{Paladin} | Un 'Paladin' quedó definido como el personaje mas simple del jeugo, aquel que tiene atributos equilibrados , el favortio de los proncipiantes

A --> C{Warrior} | Un 'Warrior' sera el conocido pór los gamers como el tanque, aque con mucha vida, lento pero muy fuerte, puede ser un gran alaidado en el contexto adecuado

A --> D{Ninja} | El 'Ninja' sera el favorito de los mas frikis del juego, aquel que parece debil, parece poco util, pero que solo aquellos que logren enetder sus atributos podran dominar

A --> E{BlackMage} | 

A --> F{WhiteMage} |

El trait 'NonPlayable' se definene metodos getters y setters uitles para las implementaciones futuras

[NonPlayable] --> G[ANonPlayable] | En la clase abstracta 'ANonPlayable' se implementan los metodos del trait, ademas de definir nuevos metodos especificos para el desarrollo de los metodos de cada enemigo y sus acciones en el juego, como atacar, ser atacados, etc

G[ANonPlayable] --> H{Enemy} | un 'Enemigo' sera aquel pobejeto dentro dle jeugo que representa al adversior el cual nuetros personajes deben derrotar


#### Tipos de personajes:
Los personajes se dividen en diferentes clases (Paladín, Guerrero, Ninja, Mago Negro, Mago Blanco) para reflejar las distintas habilidades y atributos que poseen en el juego. Cada clase tiene sus propias características únicas, como puntos de vida, ataque, defensa y mana (en el caso de los magicos).

#### Enemigos: 
Los enemigos se modelan como una clase separada debido a sus características y comportamientos únicos en comparación con los personajes controlados por el jugador. Los enemigos tienen sus propios atributos, como puntos de vida, ataque, defensa y comportamientos de ataque.

#### Armas

#### Clases abstractas y concretas: Se implementaron clases abstractas y concretas para representar armas comunes y mágicas. El diagrama de clases muestra la jerarquía de clases para armas:
[NonPlayable] --> A[AWeapon] | la clase abstracta 'AWeapon' implementa los metodos del trait ademas de agregar nuevos utiles para cada weapon

A[AWeapon] --> 

A --> B{Sword} | 'Espada' es sea la arma mas equilibrada del juego, en terminos de ataque-peso

A --> C{Axe} | 'Hacha' es un arma pesada pero poderosa

A --> D{Bow} | 'Arco' es un arma liviana y poco poderosa

A --> E{Staff} | 

A --> F{Wand}

#### Atributos de armas: 
Cada arma tiene atributos como nombre, puntos de ataque, peso y un posible propietario, lo que refleja las reglas del juego sobre el equipamiento de armas por parte de los personajes. Las armas comunes tienen atributos básicos, mientras que las armas mágicas tienen atributos adicionales como poder mágico y tipo de magia.

### Estructura del Código

El código está organizado en paquetes para una mejor modularidad y legibilidad:

#### Paquete model: 
Contiene las clases que representan los elementos del juego, como personajes, enemigos y armas.
#### Paquete controller: 
Contiene las clases que controlan el flujo del juego, como la gestión de turnos y la batalla.

#### Paquete test: 
Contiene las pruebas unitarias para verificar el correcto funcionamiento del código.

### Patrones de Diseño Utilizados

#### Herencia: 
Se utiliza para modelar la relación entre clases abstractas y concretas, permitiendo la reutilización de código y la especialización de comportamientos.
#### Traits: 
Se utilizan para definir funcionalidades comunes que se pueden compartir entre múltiples clases, promoviendo la reutilización del código y la modularidad.

### Conclusión

Final Reality es un proyecto educativo que utiliza conceptos de programación para crear un juego simplificado. La organización del código en paquetes y la utilización de patrones de diseño como herencia y traits hacen que el código sea modular, legible y fácil de mantener.



This project is licensed under the
[Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/).