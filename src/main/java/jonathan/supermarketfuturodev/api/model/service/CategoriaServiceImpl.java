package jonathan.supermarketfuturodev.api.model.service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jonathan.supermarketfuturodev.api.model.entity.Categoria;
import jonathan.supermarketfuturodev.api.model.repository.CategoriaRepository;
import jonathan.supermarketfuturodev.api.model.service.interfaces.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class CategoriaServiceImpl implements CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(Categoria categoria) {
        String nomeCategoria = categoria.getNomeCategoria().toLowerCase();
        validarNomeCategoria(nomeCategoria);
        categoria.setNomeCategoria(nomeCategoria);
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
        Categoria categoriaPesquisada = buscar(categoria.getId());
        if (Objects.nonNull(categoria)) {
            BeanUtils.copyProperties(categoria, categoriaPesquisada, "id");
            validarNomeCategoria(categoriaPesquisada.getNomeCategoria().toLowerCase());

           this.categoriaRepository.save(categoriaPesquisada);
        }
        return null;
    }

    private void validarNomeCategoria (String nomeCategoria){
        if (this.categoriaRepository.existsByNomeCategoria(nomeCategoria)){
            throw new EntityExistsException("Já existe uma catgegoria com o nome: " + nomeCategoria);
        }
    }


    @Override
    public Categoria buscar(Long id) {
        Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findById(id);

        if(categoriaPesquisada.isEmpty()) {
            throw new EntityNotFoundException("Não foi possível encontrar uma categoria com o id: " + id);
        }
        return categoriaPesquisada.get();
    }

    @Override
    public List<Categoria> listar() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public void excluir(Long id) {
        this.categoriaRepository.deleteById(id);

    }
}
