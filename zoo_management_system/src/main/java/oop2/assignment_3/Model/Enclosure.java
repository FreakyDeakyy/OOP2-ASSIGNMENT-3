package oop2.assignment_3.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an enclosure that holds animals in the Zoo Management System. Acts
 * as a Leaf node in the Composite Design Pattern.
 *
 * @author Aya
 */
public class Enclosure implements ZooComponent {
    private String name;
    private List<Animal> animals;

    /**
     * Constructs a new Enclosure with the specified name.
     *
     * @param name The name of the enclosure
     */
    public Enclosure(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    /**
     * Returns the name of the enclosure.
     *
     * @return The enclosure name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Counts and returns the total number of animals currently in this enclosure.
     *
     * @return The animal count
     */
    @Override
    public int countAnimals() {
        return this.animals.size();
    }

    /**
     * Adds an animal to the enclosure if it is not null and not already present.
     *
     * @param animal The animal to add
     */
    public void addAnimal(Animal animal) {
        if (animal != null && !animals.contains(animal)) {
            animals.add(animal);
        }
    }

    /**
     * Removes the specified animal from the enclosure.
     *
     * @param animal The animal to remove
     */
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    /**
     * Returns the list of all animals contained in this enclosure.
     *
     * @return List of animals
     */
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Sets or updates the name of the enclosure.
     *
     * @param name The new enclosure name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the string representation of the enclosure (its name).
     *
     * @return The enclosure name
     */
    @Override
    public String toString() {
        return this.name;
    }
}