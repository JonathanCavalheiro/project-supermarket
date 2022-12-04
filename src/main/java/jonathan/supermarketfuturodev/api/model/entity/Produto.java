package jonathan.supermarketfuturodev.api.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nomeProduto;

    @Positive
    @NotNull
    private Double valorProduto;

    private Boolean isComprado;

    @ManyToOne
    private Categoria categoria;
}
