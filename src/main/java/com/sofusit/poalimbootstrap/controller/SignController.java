package com.sofusit.poalimbootstrap.controller;

import com.sofusit.poalimbootstrap.data.entity.Sign;
import com.sofusit.poalimbootstrap.excpetion.ResourceNotFoundException;
import com.sofusit.poalimbootstrap.model.SignRequest;
import com.sofusit.poalimbootstrap.model.SignResponse;
import com.sofusit.poalimbootstrap.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signs")
public class SignController {

    @Autowired
    SignService signService;

    // Get specific sign
    @RequestMapping(value = "/{signId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignResponse> getSign(@PathVariable("signId") String signId) throws ResourceNotFoundException {
        Sign sign = signService.findById(signId);

        return new ResponseEntity<>(new SignResponse(sign), HttpStatus.OK);
    }

    // Update sign
    @RequestMapping(value = "/{signId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SignResponse> updateSign(@RequestBody SignRequest signRequest)
            throws ResourceNotFoundException {

        Sign updatedSign = signService.updateSign(signRequest.toSign());
        return new ResponseEntity<>(new SignResponse(updatedSign), HttpStatus.OK);
    }
}
