package za.ac.nwu.ac.web.sb.Controler;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountBalanceDto;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final TransactionAddFlow transactionAddFlow;
    private final TransactionSubtractFlow transactionSubtractFlow;
    private final TransactionViewFlow transactionViewFlow;

    @Autowired
    public AccountTransactionController(TransactionAddFlow transactionAddFlow, TransactionSubtractFlow transactionSubtractFlow, TransactionViewFlow transactionViewFlow) {
        this.transactionAddFlow = transactionAddFlow;
        this.transactionSubtractFlow = transactionSubtractFlow;
        this.transactionViewFlow = transactionViewFlow;

    }


    @PostMapping("add-miles")
    @ApiOperation(value = "Creates a new AddMiles transaction", notes = "Creates a new transaction in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The transaction was successful", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    @Transactional(rollbackOn = Throwable.class)

    public ResponseEntity<GeneralResponse<AccountTransactionDto>> addMiles(
            @ApiParam(value = "Request body to create new add miles", required = true)
            @RequestBody AccountTransactionDto accountTransaction,
            @RequestHeader(name = "throw_exception", required = false, defaultValue = "false") Boolean throw_exception) {
        AccountTransactionDto accountTransactionResponse = transactionAddFlow.addMiles(accountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);


        if (throw_exception) {
            throw new RuntimeException("Exception called , Transaction rolled back");
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping("subtract-miles")
    @ApiOperation(value = "Creates a new Subtract Transaction", notes = "Creates a new transaction in the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The transaction was successful", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    @Transactional(rollbackOn = Throwable.class)
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> subtractMiles(
            @ApiParam(value = "Request body to create new Subtraction", required = true)
            @RequestBody AccountTransactionDto accountTransaction,
            @RequestHeader(name = "throw_exception", required = false, defaultValue = "false") Boolean throw_exception) {
        AccountTransactionDto accountTransactionResponse = transactionSubtractFlow.subtractMiles(accountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransactionResponse);

        if (throw_exception) {
            throw new RuntimeException("Exception called , Transaction rolled back");
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    @GetMapping("{memberId}")
    @ApiOperation(value = "Fetches the specified member transaction .", notes = "Fetches the transaction corresponding to the given member.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),
    })
    public ResponseEntity<GeneralResponse<AccountBalanceDto>> getAccountTransaction(
            @ApiParam(value = "The memberId that uniquely identifies each member",
                    example = "1111",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId) {

        AccountBalanceDto accountTransaction = transactionViewFlow.getBalanceByMemberId(memberId);
        GeneralResponse<AccountBalanceDto> response = new GeneralResponse<>(true, accountTransaction);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}


