package za.ac.nwu.ac.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;


@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {


    @Query(value = "SELECT" +
            "    at" +
            "  FROM" +
            "    AccountType at" +
            "  WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);


}


