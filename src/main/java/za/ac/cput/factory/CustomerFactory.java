/**CustomerFactory.java
Factory for the CustomerFactory
Author:Andy William Hine (219259038)
Date:07 June 2021
 **/

package za.ac.cput.factory;

import za.ac.cput.entity.Customer;
import za.ac.cput.generic.GenericHelper;

public class CustomerFactory
{

    public static Customer createCustomer(String name, String surname, String emailAddress,
                                          String homeAddress, long phoneNumber)
    {

        Customer customer = new Customer.Builder()
                .setCustomerID(GenericHelper.generateUniqueIntId())
                .setName(name)
                .setSurname(surname)
                .setEmailAddress(emailAddress)
                .setHomeAddress(homeAddress)
                .setPhoneNumber(phoneNumber)
                .build();
        return customer;
    }

    public static Customer updateCustomer(int customerID , String name, String surname, String emailAddress,
                                          String homeAddress, int phoneNumber)
    {
        return new Customer.Builder()
                .setCustomerID(customerID)
                .setName(name)
                .setSurname(surname)
                .setEmailAddress(emailAddress)
                .setHomeAddress(homeAddress)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}
