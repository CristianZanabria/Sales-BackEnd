package function;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer idEmployee;

    @ToString.Include
    private String  name;
    private String  job;
    private LocalDate birthDate;
    @ToString.Include
    private Double salary;
    private String department;

}
