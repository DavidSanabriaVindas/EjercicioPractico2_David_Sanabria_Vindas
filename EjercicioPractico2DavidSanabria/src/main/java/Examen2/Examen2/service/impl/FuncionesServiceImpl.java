package Examen2.Examen2.service.impl;

import Examen2.Examen2.dao.FuncionesDao;
import Examen2.Examen2.domain.Funciones;
import Examen2.Examen2.service.FuncionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FuncionesServiceImpl implements FuncionesService {

    @Autowired
    private FuncionesDao funcionesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Funciones> getFunciones() {
        return funcionesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Funciones getFuncion(Funciones funcion) {
        return funcionesDao.findById(funcion.getIdFuncion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Funciones funcion) {
        funcionesDao.save(funcion);
    }

    @Override
    @Transactional
    public void delete(Funciones funcion) {
        funcionesDao.delete(funcion);
    }
}
