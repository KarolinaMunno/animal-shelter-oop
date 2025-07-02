import java.util.ArrayList;

public class Discussion7Recursion {
    
    //Abstract class for Animal Schelter
    private static abstract class AnimalShelter {
        abstract void getAdoptionStatus();
    }
        
    //Class for Animal that extends AnimalShelter
    private static class Animal extends AnimalShelter {   
        private String name;
        private String species;
        private int age;
        private boolean adopted;

        //Constructor for Animal
        public Animal(String name, String species, int age) {
            this.name = name;
            this.species = species;
            this.age = age;
            this.adopted = false;
        }
        
        
        //Method to output the status of Animal Adoption
        @Override
        public void getAdoptionStatus() {
            System.out.println("Name: " + name);
            System.out.println("Species: " + species);
            System.out.println("Age: " + age);
            System.out.println("Adoption Status: " + (adopted ? 
                    "Adopted" : "Available for adoption"));
            System.out.println();
        }
        
        //Method for adopted Animal
        public void adopt() {
            this.adopted = true;
        }
    }
    
    //Class for Shelter that extends AnimalShelter
    private static class Shelter extends AnimalShelter {
        private String name;
        private ArrayList<AnimalShelter> components;
        
        //Constructor for Shelter
        public Shelter(String name) {
            this.name = name;
            this.components = new ArrayList<>();
            
        }
        
        //Method to add components
        public void addComponents(AnimalShelter component) {
            components.add(component);
        }
   
       
        //Method to output adoption status
        @Override
        public void getAdoptionStatus() {
            System.out.println("Shelter: " + name);
            getAdoptionStatusRecursion(0);
            
        }
        
        //Use recursion 
        private void getAdoptionStatusRecursion (int index) {
            if (index < components.size()) {
                AnimalShelter component = components.get(index);
                component.getAdoptionStatus();
                getAdoptionStatusRecursion(index + 1);
            }
        }
    }

    
    //Call main
    public static void main(String[] args) {
        Shelter shelter = new Shelter("Animal Shelter");

        //Add animals to shelter
        shelter.addComponents(new Animal("Scotty", "Dog", 7));
        shelter.addComponents(new Animal("Betsy", "Cat", 5));
        shelter.addComponents(new Animal("Diego", "Dog", 2));
        
        Shelter wildShelter = new Shelter("Wild Animal Shelter");
        
        //Add animals to wild shelter
        wildShelter.addComponents(new Animal("Betsy", "Parrot", 2));


        shelter.addComponents(wildShelter);
        
        //Output adoption status
        shelter.getAdoptionStatus();
            

        
        
    }
}

