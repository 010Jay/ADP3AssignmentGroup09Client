package za.ac.cput.entity;
/*
    AdoptionRecord.java
    Entity for the AdoptionRecord
    Author: Siyanda Hlongwa (217091229)
    Date: 04 June 2021
 */

import java.util.Date;

public class AdoptionRecord {// start of AdoptionRecord class

    //Attributes
    private int adoptionId;
    private int dogId;
    private int customerId;
    private int staffId;
    private Date date;

    protected AdoptionRecord(){}

    //Constructor
    public AdoptionRecord(Builder builder)
    {
        this.adoptionId = builder.adoptionId;
        this.customerId = builder.customerId;
        this.date = builder.date;
        this.dogId = builder.dogId;
        this.staffId = builder.staffId;
    }

    //toString method
    @Override
    public String toString() {
        return "AdoptionRecord{" +
                "adoptionId=" + adoptionId +
                ", dogId=" + dogId +
                ", customerId=" + customerId +
                ", staffId=" + staffId +
                ", date=" + date +
                '}';
    }

    public int getAdoptionId() {
        return adoptionId;
    }

    public int getDogId() {
        return dogId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public Date getDate() {
        return date;
    }

    public void setAdoptionId(int adoptionId) {
        this.adoptionId = adoptionId;
    }

    public void setDogId(int dogId) {
        this.dogId = dogId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Builder class
    public static class Builder {

        //Attributes
        private int adoptionId;
        private int customerId;
        private Date date;
        private int dogId;
        private int staffId;

        //Builder initialisation
        public Builder setAdoptionId(int adoptionId) {
            this.adoptionId = adoptionId;
            return this;
        }

        public Builder setDogId(int dogId) {
            this.dogId = dogId;
            return this;
        }

        public Builder setCustomerId(int customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setStaffId(int staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        //Returning AdoptionRecord instance with builder's attributes
        public AdoptionRecord build() {

            return new AdoptionRecord(this);
        }

        //Copy/Clone method
        public Builder copy(AdoptionRecord adoptionRecord){

            this.adoptionId = adoptionRecord.adoptionId;
            this.customerId = adoptionRecord.customerId;
            this.date = adoptionRecord.date;
            this.dogId = adoptionRecord.dogId;
            this.staffId = adoptionRecord.staffId;

            return this;
        }

    }

}//end of AdoptionRecord class
