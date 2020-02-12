package com.example.demo;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

//      @GetMapping("/")
//    public ResponseDTO test(@RequestParam("hora") String hora, @RequestParam("timezone") String timezone){
////        DateTime now = new DateTime(System.currentTimeMillis(), DateTimeZone.forID("UTC"));
////
//
////        System.out.println("esta es "+parts[1]);
////        TimeUnit.HOURS.toMillis(Long.parseLong(parts[1]));
////
////        System.out.println("Current time is: " + now);
//
//
//
//        Date date;
//        String[] parts =timezone.split("-");
//
//        if(timezone.charAt(0) == '-')
//        {
//            date = Date.from(Instant.from(Instant.now()
//                    .atZone(ZoneId.of("UTC"))
//                    .minusHours(Long.parseLong(parts[1]))));
//            date = Date.from(Instant.from(Instant.now()
//                    .atZone(ZoneId.of("UTC"))
//                    .minusHours(Long.parseLong(parts[1]))));
//        }
//        else{
//            date = Date.from(Instant.from(Instant.now()
//                    .atZone(ZoneId.of("UTC"))
//                    .plusHours(Long.parseLong(parts[1]))));
//        }
//
//
////        Date date= new Date();
//        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
//        String dateFormatted = formatter.format(date);
//
////        Date date = Calendar.getInstance().getTime();
////        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
////        String dateTimeUTC= dateFormat.format(date);
////        String dateTimeUTC3 = null;
////
////        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
////        Date dateUTC;
////        try {
////            dateUTC = sdf.parse(dateTimeUTC);
////
////            sdf.setTimeZone(TimeZone.getTimeZone("UTC-8"));
////            dateTimeUTC3 = sdf.format(dateUTC);
////        } catch (ParseException e) {
////
////        }
////
////        System.out.println(dateTimeUTC3);
////
//
//
////        String dateTimeUTC = "2015/09/28 20:00:00";
////        String dateTimeUTC3 = null;
////
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
////        Date dateUTC;
////        try {
////            dateUTC = sdf.parse(dateTimeUTC);
////
////            sdf.setTimeZone(TimeZone.getTimeZone("UTC-3"));
////            dateTimeUTC3 = sdf.format(dateUTC);
////        } catch (ParseException e) {
////
////        }
////
////        System.out.println(dateTimeUTC3);
//
////        return dateFormatted;
//
//        ResponseDTO responseDTO = new ResponseDTO();
//        TimeDTO timeDTO= new TimeDTO();
//        timeDTO.setTime(dateFormatted);
//        timeDTO.setTimeZone("3");
//        responseDTO.setTime(timeDTO);
//        return responseDTO;
//    }


    @GetMapping("/")
    public ResponseDTO time(@RequestParam("hora") String hora, @RequestParam("timezone") String timezone){
        ResponseDTO response = new ResponseDTO();
        try {
            Date date;
            String[] parts =timezone.split("-");

            if(timezone.charAt(0) == '-')
            {
                date = Date.from(Instant.from(Instant.now()
                        .atZone(ZoneId.of("UTC"))
                        .minusHours(Long.parseLong(parts[1]))));
            }
            else{
                date = Date.from(Instant.from(Instant.now()
                        .atZone(ZoneId.of("UTC"))
                        .plusHours(Long.parseLong(parts[1]))));
            }


            //        Date date= new Date();
            DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            String dateFormatted = formatter.format(date);

            ResponseDTO responseDTO = new ResponseDTO();
        TimeDTO timeDTO= new TimeDTO();
        timeDTO.setTime(dateFormatted);
        timeDTO.setTimeZone(timezone);
        responseDTO.setTime(timeDTO);
        return responseDTO;
        }catch (Exception e) {

            ErrorDTO error = new ErrorDTO();
            error.setMessage(e.getMessage());
            response.setTime(response);
            return response;
        }


    }

}
