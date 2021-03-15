package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long petId;

    @Column(name = "race")
    private String race;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "is_vaccinated")
    private boolean isVaccinated;

    @OneToMany(mappedBy = "pet")
    private List<Consult> consults;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;


    public Pet() {
    }

    public Pet(String race, String name, String birthDate, boolean isVaccinated, Owner owner) {
        this.race = race;
        this.name = name;
        this.birthDate = birthDate;
        this.isVaccinated = isVaccinated;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", race='" + race + '\'' +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
