# Lord of the click #

### Member ###

Natanon Poonawagul 5710546208  
Natcha Pongsupanee 5710546224

Patinya Yongyai 5710547204

### Use resolution as Genymotion Samsung Galaxy S6 6.0.0 

### 1. Project explanation ###

    This project is the idle clicker game which you play as the swordmaster whose object is to kill the monsters
by click at them. When a monster die you got a gold. Gold use for upgrade your sword for a better damage , buy skills
for easier game play (Like double damage or critical) and hire a friends to help you fight with the monster (friend is auto attacking).

### 2. Design Pattern ###

2.1) Factory Pattern
    - MonsterFactory
    - FriendFactory
    
    Use index for create a monster or friend instead of call its classes itself.
    
2.2) Strategy Pattern
    - SkillHero
    - DoubleDamage_Skill
    - Critical_Skill
    
    A SkillHero interface use to represent those 2 concrete class that do similar thing.
    
2.3) State Pattern
    - PlayState
    - SkillMenuState
    - FriendMenuState
    - ListSkillMenuState
    - MenuState
    
    A State for swaping menu bar etc.
    
2.4) Observer Pattern
    - PlayState
    - SkillHero
    - TextDmg
    - TextDmgPool
    
    These classes update in the playstate for real time update in game.
    
2.5) Flyweight Pattern
    - MyFriend
    - All classes in package friends
    
    These classes implements the MyFriend interface and use the same method when use in other classes.
    
### 3. Design Principle ###

    GRASP
        Creator : 
            - PlayState create Player
            - PlayState create monster
            - Player create Skill
            - TextDmgPool create TextDmg
            
        Information Expert :
            - MonsterFactory have all monster
            - PlayState have player , monsterfactory , hpbar, textdmg,etc.
        
        Low Coupling :
            - We Seperate skill classes (DoubleDamage_Skill,Critical_Skill).
            - We Use MonsterFactory to create monster so Playstate cant affect monster.
        
        Polymorphism :
            - SkillHero Have Concrete classes DoubleDamage_Skill and Critical_Skill.
            - MyFriend Have Concrete classes Legolas,Frodo,Gimli,Gandalf,Aragon,Saruman
            
        Controller :
            - Playstate control game play in usual way.
            - SkillMenuState control skills bought.
            - FriendMenuState control friends hired.
            - ListSkillMenuState control skills used.
            
        
        
        
    
    
    
    
    
    
    