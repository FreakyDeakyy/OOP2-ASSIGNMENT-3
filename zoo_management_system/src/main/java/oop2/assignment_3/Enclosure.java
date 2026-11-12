package oop2.assignment_3;

import java.util.ArrayList;
import java.util.List;

    /**
     * Represents an enclosure that holds animals in the Zoo Management System.
     * Acts as a Leaf node in the Composite Design Pattern.
     *
     * @author YourName
     */
    public class Enclosure implements ZooComponent {
        private String name;
        private List<Animal> animals;

        public Enclosure(String name) {
            this.name = name;
            this.animals = new ArrayList<>();
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public int countAnimals() {
            return this.animals.size();
        }

        public void addAnimal(Animal animal) {
            if (animal != null && !animals.contains(animal)) {
                animals.add(animal);
            }
        }

        public void removeAnimal(Animal animal) {
            animals.remove(animal);
        }

        public List<Animal> getAnimals() {
            return animals;
        }

        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return this.name;
        }
    }

