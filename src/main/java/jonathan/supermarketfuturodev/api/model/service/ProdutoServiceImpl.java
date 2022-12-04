package jonathan.supermarketfuturodev.api.model.service;

import jakarta.persistence.EntityNotFoundException;
import jonathan.supermarketfuturodev.api.model.entity.Produto;
import jonathan.supermarketfuturodev.api.model.repository.ProdutoRepository;
import jonathan.supermarketfuturodev.api.model.service.interfaces.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Override
    public Produto salvar(Produto produto) {

        return this.produtoRepository.save(produto);
    }

    @Override
    public Produto atualizar(Produto produto) {
        Produto produtoPesquisado = this.buscar(produto.getId());

        BeanUtils.copyProperties(produto, produtoPesquisado, "id");

        return this.produtoRepository.save((produtoPesquisado));
    }

    @Override
    public Produto buscar(Long id) {
        Optional<Produto> produtoPesquisado = this.produtoRepository.findById(id);

        if(produtoPesquisado.isEmpty()){
            throw new EntityNotFoundException("Não foi possível encotrar um produto com o id " + id);
        }
        return produtoPesquisado.get();
    }

    @Override
    public List<Produto> listar() {
        return this.produtoRepository.findAll();
    }

    @Override
    public List<Produto> listarComprados() {
        List<Produto> produtos = this.produtoRepository.findAll();
        List<Produto> listarComprados = new ArrayList<>();

        for (int i =0; i< produtos.size(); i++){
            if(produtos.get(i).getIsComprado() == true){
                listarComprados.add(produtos.get(i));
            }
        }
       return listarComprados;
    }

    @Override
    public void excluir(Long id) {
        this.produtoRepository.deleteById(id);

    }

}
