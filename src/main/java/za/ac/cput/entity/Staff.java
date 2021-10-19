package za.ac.cput.entity;

public class Staff {

    private int staffId;
    private String name;
    private String surname;

    protected Staff() {}

    //Constructor
    private Staff(Builder builder) {
        this.name = builder.name;
        this.staffId = builder.staffId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getSurname() {
        return surname;
    }

    //Builder class
    public static class Builder {

        //Attributes
        private String name;
        private int staffId;
        private String surname;

        //Initialize the builder
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStaffId(int staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Staff build() {
            return new Staff(this);
        }

        public Builder copy(Staff staff)
        {
            this.staffId = staff.staffId;
            this.name = staff.name;
            this.surname = staff.surname;
            return this;
        }
    }

    public void reviewApplication()
    {
        System.out.println("Reviewing application!!!");
    }

    public boolean approveApplication()
    {
        System.out.println("Application has been approved!!!");
        return true;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

