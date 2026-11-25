package programminglab9;

public class ProgrammingLab9 {

    public static void main(String[] args) {
        System.out.println("--- 1. TESTING INVALID INPUTS ---");

        Warrior invalidChar = new Warrior("BrokenKnight", 150, -50, 10);
        System.out.println(invalidChar.getCharacterInfo());

        System.out.println("\n--- 2. CREATING TEAM & ADDING CHARACTERS ---");
        Team heroes = new Team();
        Warrior aragorn = new Warrior("Aragorn", 15, 200, 30);
        Mage gandalf = new Mage("Gandalf", 18, 120, 60);
        Healer elrond = new Healer("Elrond", 14, 130, 25);

        heroes.addCharacter(aragorn);
        heroes.addCharacter(gandalf);
        heroes.addCharacter(elrond);

        heroes.addCharacter(new Warrior("Aragorn", 10, 150, 20));

        heroes.displayTeam();

        Warrior golem = new Warrior("Golem", 20, 350, 40);
        System.out.println("\nEnemy Appeared: " + golem.getCharacterInfo());

        System.out.println("\n================ ROUND 1 ================");
        heroes.attackAll(golem);
        System.out.println("Golem after Round 1 attacks: " + golem.getCharacterInfo());

        System.out.println("\nGolem counter-attacks!");
        int dmg1 = golem.attack(aragorn);
        System.out.println("Golem hit Aragorn for " + dmg1 + " damage.");
        int dmg2 = golem.attack(gandalf);
        System.out.println("Golem hit Gandalf for " + dmg2 + " damage.");

        System.out.println("\nTeam heals:");
        heroes.healTeam();
        heroes.displayTeam();

        System.out.println("\n================ ROUND 2 ================");
        heroes.attackAll(golem);
        System.out.println("Golem after Round 2 attacks: " + golem.getCharacterInfo());

        System.out.println("\nGolem counter-attacks again!");
        int dmg3 = golem.attack(elrond);
        System.out.println("Golem hit Elrond for " + dmg3 + " damage.");

        System.out.println("\nTeam heals:");
        heroes.healTeam();
        heroes.displayTeam();

        System.out.println("\n--- 3. SEARCHING AND REMOVING CHARACTERS ---");
        GameCharacter found = heroes.findByName("Gandalf");
        if (found != null) {
            System.out.println("Found character: " + found.getCharacterInfo());
        } else {
            System.out.println("Character not found.");
        }

        heroes.removeCharacter("Elrond");
        heroes.displayTeam();
    }
}
