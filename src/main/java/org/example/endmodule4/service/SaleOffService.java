package org.example.endmodule4.service;



import org.example.endmodule4.model.SaleOff;
import org.example.endmodule4.repository.ISaleOffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleOffService implements ISaleOffService{
    @Autowired
    private ISaleOffRepo saleOffRepo;
    @Override
    public Iterable<SaleOff> findAll() {
        return saleOffRepo.findAll();
    }

    @Override
    public void save(SaleOff saleOff) {
        saleOffRepo.save(saleOff);
    }

    @Override
    public Optional<SaleOff> findById(Long id) {
        return saleOffRepo.findById(id);
    }

    @Override
    public void remove(Long id) {
       saleOffRepo.deleteById(id);
    }
}
