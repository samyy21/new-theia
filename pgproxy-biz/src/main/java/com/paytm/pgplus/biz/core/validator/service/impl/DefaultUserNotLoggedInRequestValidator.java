/*
 * This File is the sole property of Paytm(One97 Communications Limited)
 */
package com.paytm.pgplus.biz.core.validator.service.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.paytm.pgplus.biz.core.validator.BizParamValidator;
import com.paytm.pgplus.biz.core.validator.service.IValidator;
import com.paytm.pgplus.biz.workflow.model.WorkFlowRequestBean;
import com.paytm.pgplus.pgproxycommon.enums.ResponseConstants;
import com.paytm.pgplus.pgproxycommon.models.GenericCoreResponseBean;

/**
 * @author manojpal
 *
 */
@Service("defaultUserNotLoggedInValidator")
public class DefaultUserNotLoggedInRequestValidator implements IValidator {
    public static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserNotLoggedInRequestValidator.class);

    @Override
    public GenericCoreResponseBean<Boolean> validate(final WorkFlowRequestBean workFlowBean) {

        String errorMessage = null;
        ResponseConstants responseConstant = null;

        if (!BizParamValidator.validateInputObjectParam(workFlowBean)) {
            LOGGER.info("Validation failed as request bean is null");
            errorMessage = "NullBeanSentForValidation";
            responseConstant = ResponseConstants.INVALID_PARAM;
        }

        if ((errorMessage == null) && !BizParamValidator.validateInputObjectParam(workFlowBean.getRequestType())) {
            LOGGER.info("validation failed as invalid request Type is Passed");
            errorMessage = "InvalidRequestType " + workFlowBean.getRequestType();
            responseConstant = ResponseConstants.INVALID_REQUEST_TYPE;
        }

        if ((errorMessage == null) && !BizParamValidator.validateInputNumberParam(workFlowBean.getTxnAmount())) {
            LOGGER.info("validation failed as invalid txnAmount is Passed");
            errorMessage = "InvalidTxnAmount " + workFlowBean.getTxnAmount();
            responseConstant = ResponseConstants.INVALID_TXN_AMOUNT;
        }

        if ((errorMessage == null) && !BizParamValidator.validateChannelID(workFlowBean.getChannelID())) {
            LOGGER.info("validation failed as invalid ChannelID is Passed");
            errorMessage = "InvalidChannelID " + workFlowBean.getChannelID();
            responseConstant = ResponseConstants.INVALID_CHANNEL;
        }

        if ((errorMessage == null) && !BizParamValidator.validateIndustryTypeID(workFlowBean.getIndustryTypeID())) {
            LOGGER.info("validation failed as invalid IndustryTypeID is Passed");
            errorMessage = "InvalidIndustryTypeID " + workFlowBean.getIndustryTypeID();
            responseConstant = ResponseConstants.INVALID_INDUSTRY_TYPE_ID;
        }

        /*
         * if (StringUtils.isBlank(errorMessage) &&
         * !BizParamValidator.validateWebsite(workFlowBean.getWebsite())) {
         * LOGGER.info("validation failed as invalid website is Passed");
         * errorMessage = "InvalidWebsite " + workFlowBean.getWebsite();
         * responseConstant = ResponseConstants.INVALID_PARAM; }
         */

        if (StringUtils.isBlank(errorMessage) && StringUtils.isNotBlank(workFlowBean.getMobileNo())
                && !BizParamValidator.validateInputNumberParam(workFlowBean.getMobileNo())) {
            LOGGER.info("validation failed as invalid Mobile Number is Passed");
            errorMessage = "InvalidMobileNumber";
            responseConstant = ResponseConstants.INVALID_MOBILE_NUMBER;
        }

        if (StringUtils.isBlank(errorMessage) && StringUtils.isNotBlank(workFlowBean.getEmailID())
                && !BizParamValidator.validateInputStringParam(workFlowBean.getEmailID())) {
            LOGGER.info("validation failed as invalid emailId is Passed");
            errorMessage = "InvalidEmail " + workFlowBean.getEmailID();
            responseConstant = ResponseConstants.INVALID_PARAM;
        }

        /*
         * Validating Optional parameters
         */
        // TODO: Validation for Payment_Mode_Only pending

        // Validating AuthMode
        if (StringUtils.isBlank(errorMessage) && BizParamValidator.validateInputStringParam(workFlowBean.getAuthMode())
                && !BizParamValidator.validateAuthMode(workFlowBean.getAuthMode())) {
            LOGGER.info("validation failed as invalid AuthMode is Passed");
            errorMessage = "InvalidAuthMode " + workFlowBean.getAuthMode();
            responseConstant = ResponseConstants.INVALID_PARAM;
        }

        if (StringUtils.isBlank(errorMessage) && StringUtils.isNotBlank(workFlowBean.getPaymentTypeId())
                && !BizParamValidator.validatePaymentTypeId(workFlowBean.getPaymentTypeId())) {
            LOGGER.info("validation failed as invalid PaymentTypeId is Passed. Only CC,DC,NB & IMPS supported");
            errorMessage = "InvalidPaymentTypeId " + workFlowBean.getPaymentTypeId();
            responseConstant = ResponseConstants.INVALID_PARAM;
        }

        if (StringUtils.isBlank(errorMessage) && !BizParamValidator.validateCardType(workFlowBean.getCardType())
                && StringUtils.isNotBlank(workFlowBean.getCardType())) {
            LOGGER.info("validation failed as invalid CardType is Passed");
            errorMessage = "InvalidCardType";
            responseConstant = ResponseConstants.INVALID_PARAM;
        }

        return errorMessage == null ? new GenericCoreResponseBean<Boolean>(true)
                : new GenericCoreResponseBean<Boolean>(errorMessage, responseConstant);
    }

}
