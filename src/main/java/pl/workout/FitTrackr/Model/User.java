package pl.workout.FitTrackr.Model;

import jakarta.persistence.*;
import lombok.*;
import pl.workout.FitTrackr.Model.Enum.Role;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Route> routes;
    @ManyToMany
    @JoinTable(
            name = "users_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<SportGroup> groups;

    @Enumerated(EnumType.STRING)
    private Role role;

}
