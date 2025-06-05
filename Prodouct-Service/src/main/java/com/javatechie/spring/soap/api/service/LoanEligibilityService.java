package com.javatechie.spring.soap.api.service;

import java.security.SecureRandom;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.javatechie.spring.soap.api.loaneligibility.Acknowledgement;
import com.javatechie.spring.soap.api.loaneligibility.CustomerRequest;

@Service
@Slf4j
public class LoanEligibilityService {


	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int CODE_LENGTH = 10;
	private static final SecureRandom random = new SecureRandom();

	public Acknowledgement checkLoanEligibility(CustomerRequest request) {
		Acknowledgement acknowledgement = new Acknowledgement();


		log.info("CustomerRequest  DTO recievedx: {}  " , request );

		List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

		if (!(request.getAge() > 30 && request.getAge() <= 60)) {
			mismatchCriteriaList.add("Person age should in between 30 to 60");
		}
		if (!(request.getYearlyIncome() > 200000)) {
			mismatchCriteriaList.add("minimum income should be more than 200000");
		}
		if (!(request.getCibilScore() > 500)) {
			mismatchCriteriaList.add("Low CIBIL Score please try after 6 month");
		}

		if (mismatchCriteriaList.size() > 0) {
			acknowledgement.setApprovedAmount(0);
			acknowledgement.setIsEligible(false);
		} else {
			acknowledgement.setApprovedAmount(500000);
			acknowledgement.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		acknowledgement.setReferenceNumber(generateUniqueCode());

		Acknowledgement.TransferResult transferResult = new Acknowledgement.TransferResult();
		transferResult.setPostingDate("20250505");
		Acknowledgement.TransferResult.TransactionStatus transactionStatus = new Acknowledgement.TransferResult.TransactionStatus();
		transactionStatus.setErrorCode(0);
		transactionStatus.setExtendedReply("");
		transactionStatus.setExternalReferenceNo("551584172202505051011100311201");
		transactionStatus.setIsOverriden(false);
		transactionStatus.setIsServiceChargeApplied(false);
		transactionStatus.setReplyCode(0);
		transactionStatus.setReplyText("");
		transactionStatus.setSpReturnValue(0);
		transferResult.setTransactionStatus(transactionStatus);
		Acknowledgement.TransferResult.FileTransferDetails fileTransferDetails = new Acknowledgement.TransferResult.FileTransferDetails();
		fileTransferDetails.setFileName("AEPS0505252C_447.txt");
		fileTransferDetails.setFileTransferStatus("File Uploaded Successfully.");
		fileTransferDetails.setReferenceNumber("GEFU050512073310");
		transferResult.setFileTransferDetails(fileTransferDetails);
		transferResult.setRequestId("675448845");
		acknowledgement.setTransferResult(transferResult);


		return acknowledgement;

	}




	public static String generateUniqueCode() {
		StringBuilder code = new StringBuilder(CODE_LENGTH);
		for (int i = 0; i < CODE_LENGTH; i++) {
			int index = random.nextInt(CHARACTERS.length());
			code.append(CHARACTERS.charAt(index));
		}
		return code.toString();
	}

}
