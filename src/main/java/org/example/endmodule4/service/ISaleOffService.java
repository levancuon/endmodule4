package org.example.endmodule4.service;


import org.example.endmodule4.model.SaleOff;

import java.util.Optional;

public interface ISaleOffService {
    Iterable<SaleOff> findAll();

    void save(SaleOff saleOff);

    Optional<SaleOff> findById(Long id);

    void remove(Long id);
}
