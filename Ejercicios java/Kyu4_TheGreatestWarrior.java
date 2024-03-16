//https://www.codewars.com/kata/5941c545f5c394fef900000c
import java.util.*;
class Warrior {
    String[] ranks = {"Pushover", "Novice", "Fighter", "Warrior", "Veteran", "Sage", "Elite", "Conqueror", "Champion", "Master", "Greatest"};
    public String name;
    private int experience = 100;
    private int level = experience/100;
    private String rank = ranks[0];
    private ArrayList<String> achievements = new ArrayList<String>();
    public Warrior(){
      
    }
    public Warrior(String name, int level, int experience){
        this.name = name;
        this.level = setLevel(experience);
        this.rank = ranks[setRank(level)];
    }
    public int level(){
      return level;
    }
    public int experience(){
      return experience;
    }
    public String rank(){
      return rank;
    }
    public ArrayList<String> achievements(){
      return achievements;
    }
  
    int setLevel(int experience){
        return experience/100;
    }
    int setRank(int level){
      return level/10;
    }
    int capLevel(int level){
        if(level > 100){
          return 100;
        }
        return level;
    }
    int capExperience(int experience){
      if(experience > 10000){
        return 10000;
      }
      return experience;
    }
    public String battle(int enemyLevel){
        int levelDiff = enemyLevel - level;
        if(enemyLevel < 1 || enemyLevel > 100){
            return "Invalid level";
        }
        if(level / 10 < enemyLevel / 10 && levelDiff >= 5){
            return "You've been defeated";
        }
        if(levelDiff == 0){
            this.experience += 10;
            experience = capExperience(experience);
            level = capLevel(subirNivel());
            rank = ranks[subirRank()];
        } else if(levelDiff == -1){
            this.experience += 5;
            experience = capExperience(experience);
            level = capLevel(subirNivel());
            rank = ranks[subirRank()];
        } else if(levelDiff <= -2){
            this.experience += 0;
        } else if(levelDiff > 0){
            this.experience += 20 * levelDiff * levelDiff;
            experience = capExperience(experience);
            level = capLevel(subirNivel());
            rank = ranks[subirRank()];
        }
        return resultado(levelDiff);
    }
    private String resultado(int levelDiff){
        if(levelDiff <= -2){
            return "Easy fight";
        } else if (levelDiff > 0){
            return "An intense fight";
        } 
        return "A good fight";
    }
    public String training(String description, int experienceEarned, int minLevel){
        int levelDiff = level - minLevel;
        if(levelDiff >= 0){
            experience += experienceEarned;
            experience = capExperience(experience);
            level = capLevel(subirNivel());
            rank = ranks[subirRank()];
            achievements.add(description);
            return description;
        }else{
            
        }
        return "Not strong enough";
    }
    public int subirNivel(){
      return experience / 100;
    }
    public int subirRank(){
      return level/10;
    }
}
