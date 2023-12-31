package br.com.backend.challenge.api.domain.testimony;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Testimony")
@Table(name = "tb_testimony")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Testimony {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2048)
    private String picture;

    @Column(columnDefinition = "TEXT")
    private String testimony;
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;
    
    public Testimony(TestimonyFormDTO testimonyFormDto) {
        this.picture = testimonyFormDto.picture();
        this.testimony = testimonyFormDto.testimony();
        this.name = testimonyFormDto.name();
        this.isActive = true;
    }

    public void update(@Valid TestimonyUpdateFormDTO testimonyDTO) {
        if (!testimonyDTO.picture().isBlank()) {
            this.picture = testimonyDTO.picture();
        }
        if (!testimonyDTO.testimony().isBlank()) {
            this.testimony = testimonyDTO.testimony();
        }
        if (!testimonyDTO.name().isBlank()) {
            this.name = testimonyDTO.name();
        }
    }

    public void inactivate() {
        this.isActive = false;
    }

}
