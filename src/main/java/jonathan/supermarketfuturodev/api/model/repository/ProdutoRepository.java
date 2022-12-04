package jonathan.supermarketfuturodev.api.model.repository;

import jonathan.supermarketfuturodev.api.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long>{
}
