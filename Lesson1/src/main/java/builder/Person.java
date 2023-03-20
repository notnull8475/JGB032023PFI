package builder;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static Builder newBuilder() {
        return new Person().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setFirstName(String firstName) {
            Person.this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            Person.this.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            Person.this.middleName = middleName;
            return this;
        }

        public Builder setCountry(String country) {
            Person.this.country = country;
            return this;
        }

        public Builder setAddress(String address) {
            Person.this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            Person.this.phone = phone;
            return this;
        }

        public Builder setAge(int age) {
            Person.this.age = age;
            return this;
        }

        public Builder setGender(String gender) {
            Person.this.gender = gender;
            return this;
        }

        public Person build() {
            return Person.this;
        }

    }
}
