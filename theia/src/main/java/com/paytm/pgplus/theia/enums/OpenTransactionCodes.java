//package com.paytm.pgplus.theia.enums;
//
//public enum OpenTransactionCodes {
//
//    PRE_LOGIN_PAGE_OPENED(810, "PRE LOGIN"), POST_LOGIN_INACTIVE_WALLET(8101, "POST LOGIN | INACTIVE WALLET"), POST_LOGIN_SUFFICIENT_WALLET_BALANCE(
//            8102, "POST LOGIN | SUFFICIENT WALLET BALANCE"), POST_LOGIN_INSUFFICIENT_WALLET_BALANCE(8103,
//            "POST LOGIN | INSUFFICIENT WALLET BALANCE"), POST_LOGIN_WALLET_FAILED(8109, "POST LOGIN | WALLET FAILED"), POST_LOGIN_ANP_AM_ALLOWED_WALLET_LIMIT_BREACHED(
//            8201, "POST LOGIN | WALLET LIMIT BREACHED | INSUFFICIENT BALANCE | ADD N PAY"), POST_LOGIN_ANP_AM_ALLOWED_PG_LIMIT_BREACHED(
//            8202, "POST LOGIN | PG LIMIT BREACHED | ADD MONEY ALLOWED | INSUFFICIENT BALANCE | ADD N PAY"), POST_LOGIN_ANP_WITHDRAW_NOT_ALLOWED(
//            8203, "POST LOGIN | WITHDRAW NOT ALLOWED | SUFFICIENT BALANCE | ADD N PAY"), POST_LOGIN_ANP_SSO_LIMIT_BREACHED(
//            8204, "POST LOGIN | WITHDRAW NOT ALLOWED | ADD N PAY"), USER_CANCEL_BANK_TXN(2271,
//            "USER DELIBERATELY CANCELLED TRANSACTION"), BANK_TXN_CANCEL(227, "TRANSACTION CANCELLED "), FORCEFUL_SESSION_TIME_OUT(
//            510, "FORCEFUL SESSION TIME OUT | EXCEPTION OCCURED"), PAGE_CLOSED_BEFORE_PAGE_LOAD(410,
//            "PAGE CLOSED BEFORE PAGE LOAD");
//
//    private OpenTransactionCodes(int code, String name) {
//        this.code = code;
//        this.name = name;
//    }
//
//    private String name;
//    private int code;
//
//    public String getName() {
//        return this.name;
//    }
//
//    public int getCode() {
//        return this.code;
//    }
//
//    public String getCodeAsString() {
//        return Integer.toString(this.code);
//    }
// }
