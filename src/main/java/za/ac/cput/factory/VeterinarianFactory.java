package za.ac.cput.factory;
import za.ac.cput.entity.Veterinarian;

/*
    VeterinarianFactory.java
    Factory for the Veterinarian entity
    Author: Nonhlahla Hlungwani (218160658)
    Date: 05 June 2021
 */
public class VeterinarianFactory {
    private static int vetID =30;


    public static Veterinarian createVeterinarian(String name, String surname, long phoneNumber, String emailAddress) {

        return new Veterinarian.Builder()
                .setVetId(++vetID)
                .setName(name)
                .setSurname(surname)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(surname)
                .build();


    }

    public static Veterinarian updateVeterinarian(int VetId , String name, String surname, int phoneNumber, String emailAddress)
    {
        return new Veterinarian.Builder()
                .setVetId(vetID)
                .setName(name)
                .setSurname(surname)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(emailAddress)
                .build();
    }



}

