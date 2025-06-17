package com.mrbarda.restapp.repo;

import com.mrbarda.restapp.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer> {
    Usuario findOneByUsername(String username);
}



