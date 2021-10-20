package za.ac.cput.factory;

import za.ac.cput.entity.Customer;
import za.ac.cput.entity.Staff;
import za.ac.cput.generic.GenericHelper;

public class StaffFactory {

    public static Staff createStaff( String name, String surname)
    {
        //Creating a staff object)

        Staff staff = new Staff.Builder()
                .setStaffId(GenericHelper.generateUniqueIntId())
                .setName(name)
                .setSurname(surname)
                .build();
        return staff;
    }

    public static Staff updateStaff(int staffID , String name, String surname)
    {
        return new Staff.Builder()
                .setStaffId(staffID)
                .setName(name)
                .setSurname(surname)
                .build();
    }

}

