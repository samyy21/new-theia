<div class="common-conv">
	<c:if test ="${txnConfig != null &&  txnConfig.paymentCharges != null && txnConfig.paymentCharges.PPI != null}">
		You will be charged 
		<span style="font-weight: 600; font-size: 11px;">
			<span class="WebRupee">Rs</span>  
			<fmt:formatNumber  maxFractionDigits = "2" value = "${txnConfig.paymentCharges.PPI.totalTransactionAmount - walletInfo.walletBalance}" /> 
		</span>
		including 
		<span style="font-weight: 600; font-size: 11px;">
			<span class="WebRupee">Rs</span> 
			 ${txnConfig.paymentCharges.PPI.totalConvenienceCharges }
		</span>
		as convenience charges.
		
		<c:set var="submitBtnText">Pay <span class="WebRupee">Rs</span> ${txnConfig.paymentCharges.PPI.totalTransactionAmount}</c:set>
	</c:if>
</div>