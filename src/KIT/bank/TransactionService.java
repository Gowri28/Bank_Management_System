package KIT.bank;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;


public class TransactionService {
	 private List<Transaction> transactions = new ArrayList<>();
	    private int transactionCounter = 1;
	    public void recordTransaction(long accno, String type, double amount) {
	        Transaction transaction = new Transaction(
	            generateTransactionId(),
	            accno,
	            amount,
	            type,
	            LocalDateTime.now()
	        );
	        transactions.add(transaction);
	    }

	    public List<Transaction> getTransactionsForAccount(long accno) {
	        return transactions.stream()
	                .filter(txn -> txn.getAccno() == accno)
	                .collect(Collectors.toList());
	    }

	    private int generateTransactionId() {
	        return transactionCounter++;
	    }

}
