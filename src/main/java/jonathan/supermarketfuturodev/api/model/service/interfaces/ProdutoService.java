package jonathan.supermarketfuturodev.api.model.service.interfaces;

import jonathan.supermarketfuturodev.api.model.entity.Produto;

import java.util.List;

public interface ProdutoService {


    Produto salvar(Produto produto);

    Produto atualizar(Produto produto);

    Produto buscar(Long id);

    List<Produto> listar();

    List<Produto> listarComprados();

    void excluir(Long id);

}
