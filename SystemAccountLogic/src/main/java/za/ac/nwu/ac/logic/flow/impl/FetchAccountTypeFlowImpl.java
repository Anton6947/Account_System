package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;


    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto>getAllAccountTypes(){
        return accountTypeTranslator.getAllAccountTypes();
    }

}

//    @Override
//    public List<AccountTypeDto> getAllAccountTypes() {
//        List<AccountTypeDto> accountTypeDtos =new ArrayList<>();
//        accountTypeDtos.add(new AccountTypeDto("Miles","Miles", LocalDate.now()));
//        return accountTypeDtos;
//    }