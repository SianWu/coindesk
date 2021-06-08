package com.cathaybk.coindesk.repositary;

import com.cathaybk.coindesk.entity.CoinDeskModel;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinDeskRepository extends CrudRepository<CoinDeskModel, Long> {
  Optional<CoinDeskModel> findByCurrency(String currency);
}
