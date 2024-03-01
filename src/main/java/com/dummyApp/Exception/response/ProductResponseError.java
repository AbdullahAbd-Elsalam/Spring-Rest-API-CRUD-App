package com.dummyApp.Exception.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseError {

   // this is the response error type
   private int code;
   private String messege;
   private long timeStamp;
}
