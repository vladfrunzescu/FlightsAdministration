package socialnetwork.domain;

import socialnetwork.utils.Hobbies;

import java.util.List;
import java.util.Objects;

public class Client extends Entity<Long>{
    private String name;
    private Integer fidelityGrade;
    private Integer varsta;
    private Hobbies hobby;


    public Client( String name, Integer fidelityGrade, Integer varsta, Hobbies hobby) {
        this.name = name;
        this.fidelityGrade = fidelityGrade;
        this.varsta = varsta;
        this.hobby = hobby;
    }

    public Client( Long ID, String name, Integer fidelityGrade, Integer varsta, Hobbies hobby) {
        this.setId(ID);
        this.name = name;
        this.fidelityGrade = fidelityGrade;
        this.varsta = varsta;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFidelityGrade() {
        return fidelityGrade;
    }

    public void setFidelityGrade(Integer fidelityGrade) {
        this.fidelityGrade = fidelityGrade;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public Hobbies getHobby() {
        return hobby;
    }

    public void setHobby(Hobbies hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "client{" +
                "Name='" + name + '\'' +
                ", Fidelity grade='" + fidelityGrade + '\'' +
                ", Varsta'" + varsta + '\'' +
                ", Hobbies=" + hobby +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client that = (Client) o;
        return getName().equals(that.getName()) &&
                getFidelityGrade() == that.getFidelityGrade() &&
                getVarsta() == that.getVarsta()
                && getHobby().equals(that.getHobby());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFidelityGrade(), getVarsta(),getHobby());
    }
}