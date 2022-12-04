package jonathan.supermarketfuturodev.api.model.service.interfaces;

import jonathan.supermarketfuturodev.api.model.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    Categoria salvar(Categoria categoria);

    Categoria atualizar(Categoria categoria);

    Categoria buscar(Long id);

    List<Categoria> listar();

    void excluir(Long id);
}
