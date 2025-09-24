package com.example.barbearia.Service;
import org.springframework.stereotype.Service;
import com.example.barbearia.Repository.BarbeiroRepository;
import com.example.barbearia.Model.BarbeiroModel;
import java.util.List;


@Service
public class BarbeiroService {
    private final BarbeiroRepository barbeiroRepository;
    public BarbeiroService(BarbeiroRepository barbeiroRepository){
        this.barbeiroRepository= barbeiroRepository;
 }

    public BarbeiroModel cadastroBarbeiro(BarbeiroModel barbeiroModel){
    return barbeiroRepository.save(barbeiroModel);
 }
    public List<BarbeiroModel> mostrarBarbeiros(){
        return barbeiroRepository.findAll();
}
    public BarbeiroModel buscar(long id){
        return barbeiroRepository.findById(id).orElse(null);
    }

    public void deletar(long id){
        barbeiroRepository.deleteById(id);
    }
}
