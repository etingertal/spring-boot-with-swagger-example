package com.sofusit.poalimbootstrap.controller;

import com.sofusit.poalimbootstrap.data.entity.Sign;
import com.sofusit.poalimbootstrap.excpetion.ResourceNotFoundException;
import com.sofusit.poalimbootstrap.model.SignRequest;
import com.sofusit.poalimbootstrap.model.SignResponse;
import com.sofusit.poalimbootstrap.service.SignService;
import io.swagger.annotations.*;
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
    @ApiOperation(value = "getSign", nickname = "getSign")
    @RequestMapping(value = "/{signId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "signId", value = "Sign's id", required = true, dataType = "string")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = SignResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity<SignResponse> getSign(@PathVariable("signId") String signId)
            throws ResourceNotFoundException {

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
