package com.example.mssql.BL.DataValidation;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public interface Validator {



    public void validateLoginData();



    public void validateData();



}
