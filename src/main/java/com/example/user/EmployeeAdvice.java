// package com.example.user;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.ResponseStatus;

// import com.example.user.User.Auth.DuplicateEmailException;

// @ControllerAdvice
// class EmployeeAdvice {

//   @ResponseBody
//   @ExceptionHandler(DuplicateEmailException.class)
//   @ResponseStatus(HttpStatus.BAD_REQUEST) // Puedes ajustar el código de estado según tus necesidades
//   String duplicateEmailHandler(DuplicateEmailException ex) {
//       return ex.getMessage();
//   }
// }
