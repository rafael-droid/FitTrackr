package pl.workout.FitTrackr.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.workout.FitTrackr.Model.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "activity")
public class Activity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String duration;
    private Double distance;
    private int caloriesBurned;
    @ManyToOne
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    private Result result;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> note;

}
