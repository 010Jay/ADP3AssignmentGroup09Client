package za.ac.cput.factory;

/**
 * DogFactory.java
 * DogFactory class for the Dog entity
 * Author: Jason Jaftha (217009301)
 * Date: 05 June 2021
 **/

import za.ac.cput.entity.Dog;
import za.ac.cput.generic.GenericHelper;

public class DogFactory {

    public static Dog createDog(String name, int age, String color, boolean isPuppy, char gender, String breed, int vetId, String vaccinationStatus)
    {
        return new Dog.Builder()
                .setDogId(GenericHelper.generateUniqueIntId())
                .setName(name)
                .setAge(age)
                .setColor(color)
                .setIsPuppy(isPuppy)
                .setGender(gender)
                .setBreed(breed)
                .setVetId(vetId)
                .setVaccinationStatus(vaccinationStatus)
                .build();
    }

    public static Dog updateDog(int dogId , String name, int age, String color, boolean isPuppy, char gender, String breed, int vetId, String vaccinationStatus)
    {
        return new Dog.Builder()
                .setDogId(dogId)
                .setName(name)
                .setAge(age)
                .setColor(color)
                .setIsPuppy(isPuppy)
                .setGender(gender)
                .setBreed(breed)
                .setVetId(vetId)
                .setVaccinationStatus(vaccinationStatus)
                .build();
    }
}
