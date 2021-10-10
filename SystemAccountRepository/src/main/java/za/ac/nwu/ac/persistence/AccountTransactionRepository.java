package za.ac.nwu.ac.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountBalanceDto( " +
            "    at.memberId, " +
            "    SUM(at.amount))" +
            "  FROM " +
            "    AccountTransaction at" +
            "  WHERE at.memberId = :memberId " +
            "  GROUP BY at.memberId ")
    AccountBalanceDto getBalanceByMemberId(Long memberId);


}
