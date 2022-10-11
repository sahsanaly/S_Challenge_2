package com.sept.challenge2.account.controller;

import com.sept.challenge2.account.model.Account;
import com.sept.challenge2.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/account")
public class AccountController {

    @Autowired
    private AccountService accountService;



    /**
     * Create new booking in the database. Booking ID is added internally.
     * @param account - booking object as json
     * @return booking object as created in database.
     * @throws Exception
     */
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createAccount(@RequestBody Account account)
            throws Exception {
        Account createdAccount = accountService.createAccount(account);
        if (createdAccount == null){
            return new ResponseEntity<>("Account already created!", HttpStatus.OK);
        }
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

//    @GetMapping(path="/doctor{doctorId}", produces = "application/json")
//    public ResponseEntity<Object> getBookingByDoctorId(@PathVariable("doctorId") Integer doctorId)
//            throws Exception {
//        List<Booking> bookingList = bookingService.findBookingByDoctorId(doctorId);
//        if (bookingList.size() > 0) {
//            return  new ResponseEntity<>(bookingList, HttpStatus.OK);
//        } else  {
//            throw new Exception("Could not find bookings for doctor");
//        }
//    }
//
//    // UPDATE booking --> patient's name, change isAvailability to false.
//
//    @GetMapping(path="/date{bookingDate}", produces = "application/json")
//    public ResponseEntity<Object> getBookingsByDate(@PathVariable("bookingDate")
//                                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate bookingDate)
//            throws Exception {
//        List<Booking> bookingList = bookingService.getAllBookingsForDate(bookingDate);
//        if (bookingList.size() > 0) {
//            return  new ResponseEntity<>(bookingList, HttpStatus.OK);
//        } else  {
//            return new ResponseEntity<>("No bookings found", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping(path="/", produces = "application/json")
//    public ResponseEntity<Object> getAllAvailabilities()
//            throws Exception {
//        List<Booking> availabilityList = bookingService.getAllAvailabilities();
//        if (availabilityList.size() > 0) {
//            return  new ResponseEntity<>(availabilityList, HttpStatus.OK);
//        } else  {
//            return new ResponseEntity<>("No availabilities found", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
//    public ResponseEntity<Object> updateBooking(@RequestBody Booking booking)
//            throws Exception {
////        System.out.println("Inside the update booking function");
////        System.out.println(booking.getBookingId());
//        bookingService.updateBooking(booking);
//        return new ResponseEntity<>("Updated booking", HttpStatus.CREATED);
//    }
}
