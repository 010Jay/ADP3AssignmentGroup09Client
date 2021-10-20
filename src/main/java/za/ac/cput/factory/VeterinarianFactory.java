package za.ac.cput.factory;
import za.ac.cput.entity.Veterinarian;
import za.ac.cput.generic.GenericHelper;

/*
    VeterinarianFactory.java
    Factory for the Veterinarian entity
    Author: Nonhlahla Hlungwani (218160658)
    Date: 05 June 2021
 */
public class VeterinarianFactory {

    public static Veterinarian createVeterinarian(String name, String surname, long phoneNumber, String emailAddress) {

        return new Veterinarian.Builder()
                .setVetId(GenericHelper.generateUniqueIntId())
                .setName(name)
                .setSurname(surname)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(emailAddress)
                .build();


    }

    public static Veterinarian updateVeterinarian(int VetId , String name, String surname, int phoneNumber, String emailAddress)
    {
        return new Veterinarian.Builder()
                .setVetId(VetId)
                .setName(name)
                .setSurname(surname)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(emailAddress)
                .build();
    }



}

