package com.example.demo.Controller;

import com.example.demo.Controller.DTO.ErrorDTO;
import com.example.demo.Controller.DTO.ResponseDTO;
import com.example.demo.Controller.DTO.TimeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

@RestController
public class MainController {

    @GetMapping("/")
    public ResponseDTO time(@RequestParam("hora") String hora, @RequestParam("timezone") String timezone) {

        try {
            Date date;


            if (timezone.charAt(0) == '-') {
                String[] parts = timezone.split("-");
                date = Date.from(Instant.from(Instant.now()
                        .atZone(ZoneId.of("UTC"))
                        .minusHours(Long.parseLong(parts[1]))));
            } else {
                String[] parts = timezone.split("");
                date = Date.from(Instant.from(Instant.now()
                        .atZone(ZoneId.of("UTC"))
                        .plusHours(Long.parseLong(parts[1]))));
            }


            DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            String dateFormatted = formatter.format(date);

            ResponseDTO responseDTO = new ResponseDTO();
            TimeDTO timeDTO = new TimeDTO();
            timeDTO.setTime(dateFormatted);
            timeDTO.setTimeZone(timezone);
            responseDTO.setTime(timeDTO);
            return responseDTO;
        } catch (Exception e) {
            ResponseDTO response = new ResponseDTO();
            ErrorDTO error = new ErrorDTO();
            error.setMessage(e.getMessage());
            response.setTime(response);
            return response;
        }


    }

}
