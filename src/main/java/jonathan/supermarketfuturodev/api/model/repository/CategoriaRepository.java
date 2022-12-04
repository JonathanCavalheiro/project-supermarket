package jonathan.supermarketfuturodev.api.model.repository;


import jonathan.supermarketfuturodev.api.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNomeCategoria (String nomeCategoria);

}

