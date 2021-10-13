package br.com.daianebellon.service.category;

import br.com.daianebellon.repository.category.CategoryRepository;
import br.com.daianebellon.validation.IdValidation;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Classe responsável por excluir/deletar a categoria.
 */
@ApplicationScoped
public class DeleteCategoryServiceImpl implements DeleteCategoryService {

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    IdValidation idValidation;

    /**
     * Metodo responsável por deletar categoria pelo id.
     * @param id identificador passado pelo usuário para exclusão da categoria referente a esse id.
     */
    @Override
    public void deleteById(ObjectId id) {
        idValidation.validatior(id);
        categoryRepository.deleteById(id);
    }

}
