package com.dersler.new_play_sales.Mernis;

//------------------------------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 8.0.1.1
//
// Created by Quasar Development 
//
// This class has been generated for test purposes only and cannot be used in any commercial project.
// To use it in commercial project, you need to generate this class again with Premium account.
// Check https://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account.
//
// Licence: B4AA575B009BBE29B12287308A1DB62C0B6D6DC85A05868402DE5AC313A55A0AB1AAF800A66D1CF598F858377972DDA80221552A07910B5C170EFCB9C465ECE5
//------------------------------------------------------------------------
import java.util.Date;


public interface CUNDateTimeConverter
{
    java.util.Date convertDateTime(String strDate);
    java.util.Date convertTime(String strDate);
    java.util.Date convertDate(String strDate);
    String convertDuration(String value);
    String getStringFromDateTime(Date value);
    String getStringFromDate(Date value);
    String getStringFromTime(Date value);
    String getStringFromDuration(String value);
}