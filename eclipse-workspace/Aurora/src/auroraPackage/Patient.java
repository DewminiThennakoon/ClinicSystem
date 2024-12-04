package auroraPackage;

//Patient class
public class Patient {
    private String nic;
    private String name;
    private String email;
    private String phone;

    public Patient(String nic, String name, String email, String phone) {
        this.nic   = nic;
        this.name  = name;
        this.email = email;
        this.phone = phone;
    }
    
    //getters and setters for Patient class
    public String getName() {
        return name;
    }

    public String getNic() {
        return nic;
    }
    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}


