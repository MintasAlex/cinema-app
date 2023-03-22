package com.training.cinemaapp.security;

import com.training.cinemaapp.models.Booking;
import com.training.cinemaapp.security.services.UserDetailsImpl;
import com.training.cinemaapp.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("userSecurity")
public class UserSecurity {
    @Autowired
    private BookingService bookingService;

    public boolean isAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
    }

    public boolean isCurrentUser(int userId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Objects.equals(userDetails.getId(), userId);
    }

    public boolean isUserBookingAuthor(int bookingId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Booking booking = bookingService.getBookingById(bookingId).get();
        return (Objects.equals(userDetails.getId(), booking.getUserId()) || isAdmin());
    }

    public boolean isUserBookingForHimself( int bookingUserId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails.getId() == bookingUserId || isAdmin();
    }

}
